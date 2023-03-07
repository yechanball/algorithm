package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1343_폴리오미노 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String board = in.readLine();
		
		StringTokenizer x = new StringTokenizer(board, ".");
		int xCnt = x.countTokens();
		StringTokenizer dot = new StringTokenizer(board, "X");
		int dotCnt = dot.countTokens();
		
		boolean isPoss = true;
		
		if(board.charAt(0) == '.') {
			sb.append(dot.nextToken());
			dotCnt--;
		}
		
		while(xCnt-- > 0) {
			String subX = x.nextToken();
			int xLen = subX.length();
			if(xLen%2 == 1) {
				isPoss = false;
				break;
			}
			if(xLen >= 4) {
				for (int i = 0; i < xLen/4; i++) sb.append("AAAA");
				if(xLen%4 == 2) sb.append("BB");
			}else sb.append("BB");

			if(dotCnt > 0) {
				sb.append(dot.nextToken());
				dotCnt--;
			}
		}
		
		System.out.print(isPoss ? sb.toString() : -1);
	}
}
