package algorithm.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		char input, last;
		boolean isCollect;
		ArrayList<Character> list; 
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			list = new ArrayList<>(); 
			isCollect = true;
			int len = Integer.parseInt(in.readLine());
			str = in.readLine();
			
			for(int i = 0; i < len; i++) {
				input = str.charAt(i);
				
				if(input == '(' || input == '[' || input == '{' || input == '<') {
					list.add(input);
				}else if(list.size() != 0){
					// 아스키 코드를 이용하여 괄호 비교
					last = list.get(list.size()-1);
					if(input == ')' && (input-last)==1) {
						list.remove(list.size()-1);
					}else if((input-last) == 2) {
						list.remove(list.size()-1);
					}else {
						isCollect = false;
						break;
					}
				}else {
					isCollect = false;
					break;
				}
			}
			if(isCollect) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.print(sb);
	}
}
