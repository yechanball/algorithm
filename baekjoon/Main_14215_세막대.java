package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14215_세막대 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int[] side = new int[3];
        for (int i = 0; i < 3; i++) {
			side[i] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(side);
        
        if (side[0] + side[1] > side[2]) System.out.println(side[0] + side[1] + side[2]);
        else System.out.println((side[0] + side[1]) * 2 -1);
	}
}
