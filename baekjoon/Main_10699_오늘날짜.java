package algorithm.baekjoon;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_10699_오늘날짜 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print(format.format(date));
	}
}
