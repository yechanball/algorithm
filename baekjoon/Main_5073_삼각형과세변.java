package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5073_삼각형과세변 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[] side = new int[3];
		while(true) {
			st = new StringTokenizer(in.readLine());
			side[0] = Integer.parseInt(st.nextToken());
			side[1] = Integer.parseInt(st.nextToken());
			side[2] = Integer.parseInt(st.nextToken());
			
			if(side[0] == side[1] && side[1] == side[2] && side[2] == side[0]) {
				if(side[0] == 0) break;
				out.write("Equilateral\n");
			} else {
				Arrays.sort(side);
				
				if(side[0] + side[1] > side[2]) {
					if(side[0] == side[1] || side[1] == side[2]) out.write("Isosceles\n");
					else out.write("Scalene\n");
				}else {
					out.write("Invalid\n");					
				}
			}
		}
		out.flush();
		out.close();
	}
}
