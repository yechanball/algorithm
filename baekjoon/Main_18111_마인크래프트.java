package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18111_마인크래프트 {
	static int[][] map;
    static int N, M, B;
    static int height = 0;
    static int time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int min = 257, max = -1;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }

        for (int h = min; h <= max; h++){
            levelGround(h);
        }

        System.out.print(time + " " + height);
    }

    private static void levelGround(int h) {
        int tmpTime = 0;
        int tmpBlock = B;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if(map[i][j] == h) continue;

                if(map[i][j] > h){
                    int diff = map[i][j] - h;
                    tmpTime += diff*2;
                    tmpBlock += diff;
                }else{
                    int diff = h - map[i][j];
                    tmpTime += diff;
                    tmpBlock -= diff;
                }
            }
        }

        if(tmpBlock < 0 || tmpTime > time) return;

        if(tmpTime == time){
            if(h > height){
                height = h;
            }
        } else if(tmpTime < time){
            time = tmpTime;
            height = h;
        }
    }
}
