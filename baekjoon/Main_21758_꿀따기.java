package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21758_꿀따기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] honey = new int[N+1];
		for(int i = 1; i <= N; i++){
			honey[i] = honey[i-1] + Integer.parseInt(st.nextToken());
		}

		int maxHoney = 0;
		for(int hive = 1; hive <= N; hive++){
			for(int bee1 = 1; bee1 <= N; bee1++){
				if(bee1 == hive) continue;

				int honey1 = honey[bee1] - honey[bee1-1];
				int honeySum1 = bee1 < hive ? honey[hive] - honey[bee1] : honey[bee1-1] - honey[hive-1];

				for(int bee2 = 1; bee2 <= N; bee2++) {
					if(bee2 == bee1 || bee2 == hive) continue;

					int honey2 = honey[bee2] - honey[bee2-1];
					int honeySum2 = bee2 < hive ? honey[hive] - honey[bee2] : honey[bee2-1] - honey[hive-1];

					int tmpHoneySum = honeySum1 + honeySum2;
					if(bee1 < hive && bee2 < hive){
						tmpHoneySum -= bee1 < bee2 ? honey2 : honey1;
						maxHoney = Math.max(maxHoney, tmpHoneySum);
					}else if(bee1 > hive && bee2 > hive){
						tmpHoneySum -= bee1 < bee2 ? honey1 : honey2;
						maxHoney = Math.max(maxHoney, tmpHoneySum);
					}else{
						maxHoney = Math.max(maxHoney, tmpHoneySum);
					}
				}
			}
		}

		System.out.print(maxHoney);
	}
}
