package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2720_세탁소사장동혁 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int T = Integer.parseInt(in.readLine());
        int quarter = 25, dime = 10, nickel = 5, penny = 1;
        
        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(in.readLine());
            
            out.write(C/quarter + " ");
            C %= quarter;
            
            out.write(C/dime + " ");
            C %= dime;
            
            out.write(C/nickel + " ");
            C %= nickel;
            
            out.write(C/penny + "\n");
        }
        out.flush();
        out.close();
	}
}
