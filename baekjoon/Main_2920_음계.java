package algorithm.baekjoon;

import java.io.*;

public class Main_2920_음계 {
	public static void main(String[] args) throws IOException {
		int hashVal = new BufferedReader(new InputStreamReader(System.in)).readLine().hashCode();
		System.out.print((hashVal == 1956384708) ? "ascending" : ((hashVal == -1341322556) ? "descending": "mixed"));
	}
}