package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17843_시계 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {			
			StringTokenizer st = new StringTokenizer(in.readLine());
			double[] angle = transAngle(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
			double ans = Math.min(Math.min(angle[1] - angle[0], angle[2] - angle[1]), angle[0] + 360 - angle[2]);
			out.write(ans+"\n");
		}
		out.flush();
		out.close();
	}
	
	public static double[] transAngle(double hour, double min, double sec) {
		double[] angle = new double[3];
		
		angle[0] = hour*30 + min/2 + sec/120;
		angle[1] = min*6 + sec/10;
		angle[2] = sec*6;
		
		Arrays.sort(angle);
		
		return angle;
	}
}
