package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main_1302_베스트셀러 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String book = in.readLine();
			
			if(map.containsKey(book)) map.compute(book, (k, v) -> v+1);
			else map.put(book, 1);
		}
		
		String title = "";
		int sale = 0;
		
		for(String key : map.keySet()) {
			int bookSale = map.get(key);
			
			if(bookSale > sale) {
				title = key;
				sale = bookSale;
			}else if(bookSale == sale && key.compareTo(title) < 0) {
				title = key;
			}
		}
		
		System.out.print(title);
	}
}
