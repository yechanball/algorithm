package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2824_최대공약수 {
	public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        
        int N = Integer.parseInt(in.readLine());
       
        BigInteger A = BigInteger.ONE;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++) {
        	A = A.multiply(new BigInteger(st.nextToken()));        	
        }
        
        int M = Integer.parseInt(in.readLine());
        
        BigInteger  B = BigInteger.ONE;
        st = new StringTokenizer(in.readLine());
        for(int i = 0; i < M; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }
        
        String gcd = A.gcd(B).toString();
        int len = gcd.length();
        
        System.out.print(len > 9 ? gcd.substring(len - 9, len) : gcd);
    }
}
