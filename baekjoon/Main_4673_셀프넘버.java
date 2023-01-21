package algorithm.baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main_4673_셀프넘버 {
	public static void main(String[] args) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] notSelfNum = new boolean[10_036];
		for(int i = 1; i <= 10000; i++) {
			int num = i;
			int tmp = i;
			while(tmp > 0) {
				num += tmp % 10;
				tmp /= 10;
			}
			notSelfNum[num] = true;
		}
		
		for (int i = 1; i <= 10000; i++) {
			if(notSelfNum[i]) continue;
			out.append(i+"\n");
		}
		out.flush();
		out.close();
	}
}
