package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2936_채식주의자 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        double ansX = 0, ansY = 0, len = 250, area = len*len/2;
        
        if (x == 0) {
        	if(y == 0) {
        		ansX = len/2;
        		ansY = len/2;
        	}else if(y < len/2) {
        		ansX = area / (len-y);
        		ansY = len - ansX;
        	}else ansX = area/y;
        }else if (y == 0) {
        	if(x < len/2) {
        		ansY = area / (len-x);
        		ansX = len - ansY;
        	}else ansY = area/x;
        }else {
        	if(x < len/2) ansX = len - area/y;
        	else ansY = len - area/x;
        }
        
        System.out.print(String.format("%.2f %.2f", ansX, ansY));
	}
}
