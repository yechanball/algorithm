package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10988_팰린드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
		  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String str = in.readLine();
	    
	    boolean isPalindrome = true;
	    int left = 0, right = str.length()-1;
		  while(left < right) {
		    if(str.charAt(left++) != str.charAt(right--)){
		        isPalindrome = false;
		        break;
		    }
		  }
		  System.out.println(isPalindrome ? 1 : 0);
	}
}
