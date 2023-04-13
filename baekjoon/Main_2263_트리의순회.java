package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2263_트리의순회 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] inOrder, postOrder;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(in.readLine());

		inOrder = new int[n];
		postOrder = new int[n];

		StringTokenizer inSt = new StringTokenizer(in.readLine());
		StringTokenizer postSt = new StringTokenizer(in.readLine());
		
		for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(inSt.nextToken());			
			postOrder[i] = Integer.parseInt(postSt.nextToken());
		}

		findPreorder(0, n - 1, 0, n - 1);

		out.write(sb.toString());
		out.flush();
		out.close();
	}

	public static void findPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart <= inEnd && postStart <= postEnd) {
			sb.append(postOrder[postEnd] + " ");

			int pos = inStart;
			for (int i = inStart; i <= inEnd; i++) {
				if (inOrder[i] == postOrder[postEnd]) {
					pos = i;
					break;
				}
			}

			findPreorder(inStart, pos - 1, postStart, postStart + pos - inStart - 1);
			findPreorder(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
		}
	}
}
