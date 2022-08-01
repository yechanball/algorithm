package HW0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Main_17478_재귀함수가뭔가요 {
	
static StringBuilder sb = new StringBuilder();
	
	static void whatRecursion(int N, int cnt) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < cnt; i++)
			str.append("____");
		if(cnt == 0)
			sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");	
		if(N == 1)
			sb.append("\n"+str+"\"재귀함수가 뭔가요?\"").append("\n"+str+"\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n"+str+"라고 답변하였지.");
		else {
			sb.append("\n").append(str).append("\"재귀함수가 뭔가요?\"").append("\n").append(str).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n").append(str).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n").append(str).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			whatRecursion(N-1, cnt+1);
			sb.append("\n").append(str).append("라고 답변하였지.");
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		whatRecursion(N+1, cnt);
		System.out.print(sb);
	}
	
	/*static void whatRecursion(int N, int cnt) {
		String str = "";
		for (int i = 0; i < cnt; i++) {
			str += "____";
		}
		if(cnt == 0) {
			System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");			
		}
		if(N == 1) {
			System.out.print("\n"+str+"\"재귀함수가 뭔가요?\"");
			System.out.print("\n"+str+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.print("\n"+str+"라고 답변하였지.");
		}
		else {
			System.out.print("\n"+str+"\"재귀함수가 뭔가요?\""); 
			System.out.print("\n"+str+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.print("\n"+str+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지."); 
			System.out.print("\n"+str+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			whatRecursion(N-1, cnt+1);
			System.out.print("\n"+str+"라고 답변하였지.");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		whatRecursion(N+1, cnt);
	}*/
}
