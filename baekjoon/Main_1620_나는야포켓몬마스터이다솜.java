package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String input;
		
		HashMap<String,Integer> pokemonName = new HashMap<String,Integer>();
		HashMap<Integer,String> pokemonNum = new HashMap<Integer,String>();		
		for (int i = 1; i <= N; i++) { // 입력
			input = in.readLine();
			pokemonName.put(input, i);
			pokemonNum.put(i, input);
		}
		
		for (int i = 0; i < M; i++) { // 찾기
			input = in.readLine();
			if(Character.isDigit(input.charAt(0))) sb.append(pokemonNum.get(Integer.parseInt(input))).append("\n");
			else sb.append(pokemonName.get(input)).append("\n");
		}
		System.out.print(sb);
	}
}
