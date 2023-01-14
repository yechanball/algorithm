package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++){
            String str = in.readLine();

            boolean[] alphaCheck = new boolean[26];
            boolean isPoss = true;

            char preCh = str.charAt(0);
            alphaCheck[preCh - 'a'] = true;

            for (int j = 1, len = str.length(); j < len; j++){
                char now = str.charAt(j);
                if(preCh == now) continue;
                if(alphaCheck[now - 'a']){
                    isPoss = false;
                    break;
                }
                alphaCheck[now - 'a'] = true;
                preCh = now;
            }

            if(isPoss) cnt++;
        }

        System.out.print(cnt);
    }
}
