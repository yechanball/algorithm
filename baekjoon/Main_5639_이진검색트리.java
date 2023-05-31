package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main_5639_이진검색트리 {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> tree = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String key = in.readLine();
			
			if(key == null) break;
			
			tree.add(Integer.parseInt(key));
		}

		postOrder(0, tree.size()-1);
		
		out.write(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void postOrder(int idx, int end) {
		if(idx > end) return;
		
		int mid = idx+1;
		while(mid <= end && tree.get(mid) < tree.get(idx)) mid++;
		
		postOrder(idx+1, mid-1);
		postOrder(mid, end);
		
		sb.append(tree.get(idx) + "\n");
	}
}
