package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9300_WhereIsTheRainbow {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			double h = Double.parseDouble(st.nextToken());
			double theta = Double.parseDouble(st.nextToken());
			
			double len = h / Math.tan(Math.toRadians(theta));
			double d = Math.abs(len - h);
			
			if(Math.abs(len - d) < 0.000001) {
				out.write("Case "+tc+": Infinity\n");				
			}else {
				if(d < 0.000001) d = 0;
				out.write("Case "+tc+": "+d+"\n");
			}
		}
        out.flush();
        out.close();
	}
}
