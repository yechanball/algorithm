package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_7694_Triangle {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main (String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        while (true) {			
        	List<Point> arr = new ArrayList<>();
        	int n = 3;
        	boolean isEnd = true;
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				arr.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				
				if(isEnd && (arr.get(i).x != 0 || arr.get(i).y != 0)) isEnd = false;
			}
			if (isEnd) break;
			arr.add(arr.get(0));
			
			int crossCnt = 0;
			for (int i = 0; i < n; i++) {
				crossCnt += gcd(Math.abs(arr.get(i).x - arr.get(i+1).x), Math.abs(arr.get(i).y - arr.get(i+1).y));	
			}
			
			int area = 0;
            for (int i = 0; i < n; i++) {
                area += arr.get(i).x * arr.get(i + 1).y - arr.get(i).y * arr.get(i + 1).x;
            }

            int ans = (Math.abs(area) + 2 - crossCnt) / 2;
            out.write(ans + "\n");
		}
		out.flush();
		out.close();
    }
    
	public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}