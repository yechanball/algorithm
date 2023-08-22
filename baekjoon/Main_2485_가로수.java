package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2485_가로수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
        
		int[] tree = new int[N];
        for (int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(in.readLine());
        }
        Arrays.sort(tree);
       
        int GCD = 0;
        for (int i = 1; i < N; i++){
            int dist = tree[i] - tree[i-1];
            GCD = gcd(dist, GCD);
        }
        
        int ans = (tree[N-1] - tree[0])/GCD - (N - 1);
        System.out.println(ans);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}
}
