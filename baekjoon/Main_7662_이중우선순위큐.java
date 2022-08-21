package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// TreeMap은 key를 기준으로 정렬된 상태 유지
			// TrreMap -> key : 주어진 숫자, value: 숫자 개수
			// getOrDefault(Object key, V DefaultValue)
			// 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환, 그렇지 않으면 DefaultValue이 반환.
			TreeMap<Integer, Integer> tMap = new TreeMap<>(); 

			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				char input = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(input == 'D') { // D 연산인 경우 삭제
					if(!tMap.isEmpty()) {
						if(num == 1) { // D 1 : 최댓값 제거
							int maxKey = tMap.lastKey();
							if(tMap.get(maxKey) == 1) // 최댓값이 하나밖에 없다면 제거
								tMap.remove(maxKey);
							else // 최댓값이 한개보다 많다면 개수를 하나 줄이기
								tMap.put(maxKey, tMap.get(maxKey) - 1);
						}
						else { // D -1 : 최솟값 제거
							int minKey = tMap.firstKey();
							if(tMap.get(minKey) == 1) // 최솟값이 하나밖에 없다면 제거
								tMap.remove(minKey);
							else // 최솟값이 한개보다 많다면 개수를 하나 줄이기
								tMap.put(minKey, tMap.get(minKey) - 1);
						}
					}
				}else { // I 연산인 경우 삽입
					tMap.put(num, tMap.getOrDefault(num, 0) + 1);				}
			}
			if(tMap.isEmpty()) sb.append("EMPTY").append("\n"); // 비어있는 경우
			else sb.append(tMap.lastKey()).append(" ").append(tMap.firstKey()).append("\n"); // 최댓값 최솟값 출력
		}
		out.write(sb.toString());
		out.flush();
		out.close();
	}
}