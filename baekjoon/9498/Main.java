import java.util.Scanner;
import java.io.FileInputStream;

class Main{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("./input.txt"));
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