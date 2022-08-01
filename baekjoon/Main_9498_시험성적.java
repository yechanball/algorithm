package algorithm.baekjoon;

import java.util.Scanner;

public class Main_9498_시험성적 {
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
        char grade;

        if(score>=90 && score<=100){
            grade = 'A';
        }else if(score>=80 && score<=89){
            grade = 'B';
        }else if(score>=70 && score<=79){
            grade = 'C';
        }else if(score>=60 && score<=69){
            grade = 'D';
        }else{
            grade = 'F';
        }

        System.out.println(grade);
		sc.close();
	}
}
