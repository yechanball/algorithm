package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static List<Character> list = new ArrayList<Character>();
	static char[] result;
	static int L, C; // L:암호길이, C:주어진 문자 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			list.add(st.nextToken().charAt(0));
		}
		list.sort(new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return c1 - c2;
			}
		});
		
		result = new char[L];
		combi(0, 0, 0, 0); // 암호 조합 생성
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void combi(int cnt, int start, int moum, int jaum) {
		if(cnt == L) { // 암호 길이에 맞추어 단어를 다 뽑은 경우
			if(moum >= 1 && jaum >= 2) { // 모음이 1개 이상, 자음이 2개 이상인지 체크
				for (int i = 0; i < L; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			result[cnt] = list.get(i);
			if(result[cnt] == 'a' || result[cnt] == 'e' || result[cnt] == 'i' || result[cnt] == 'o' || result[cnt] == 'u') // 모음인 경우
				combi(cnt+1, i+1, moum+1, jaum);
			else // 자음인 경우
				combi(cnt+1, i+1, moum, jaum+1);
		}
	}
}
