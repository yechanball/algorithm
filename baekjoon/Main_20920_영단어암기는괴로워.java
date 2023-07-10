package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20920_영단어암기는괴로워 {
	static class Word {
		String word;
		int cnt;
		
		public Word(String word, int cnt) {
			this.word = word;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			
			if(word.length() >= M) {
				map.put(word, map.getOrDefault(word, 0) + 1);				
			}
		}
		
		List<Word> list = new ArrayList<Word>();
		for (String word : map.keySet()) {
			list.add(new Word(word, map.get(word)));
		}

		Collections.sort(list, new Comparator<Word>() {
			@Override
			public int compare(Word w1, Word w2) {
				if(w1.cnt == w2.cnt) {
					if(w1.word.length() == w2.word.length()) {
						return w1.word.compareTo(w2.word);						
					}
					return w2.word.length() - w1.word.length();					
				}
				return w2.cnt - w1.cnt;
			}
		});
		
		for(Word w : list) {
			sb.append(w.word + "\n");
		}
		System.out.println(sb.toString());
	}
}
