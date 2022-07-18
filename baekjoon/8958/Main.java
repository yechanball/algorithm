import java.util.Scanner;
import java.io.FileInputStream;

class Main{
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("./input.txt"));
		Scanner sc = new Scanner(System.in);
		int T, i, j;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
            String str = sc.next();
            int tmp = 0, answer = 0;

            for(i=0; i<str.length(); i++){
                if(str.charAt(i) == 'O'){
                    tmp++;
                    answer += tmp;
                }else{
                    tmp = 0;
                }
            }
            
            System.out.println(answer);
		}
		sc.close();
	}
}