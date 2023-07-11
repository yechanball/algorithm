package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15889_호안에수류탄이야 {
    public static void main(String args[]) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      
      int[] pos = new int[N];
      StringTokenizer st = new StringTokenizer(in.readLine());
      for(int i = 0; i < N; i++){
          pos[i] = Integer.parseInt(st.nextToken());
      }
      
      boolean isPoss = true;
      int maxRange = 0;
      
      if(N != 1){
          st = new StringTokenizer(in.readLine());
          for(int i = 0; i < N-1; i++){
              int range = Integer.parseInt(st.nextToken());
              maxRange = Math.max(maxRange, pos[i]+range);
              if(maxRange < pos[i+1]) isPoss = false;
          }
      }
      
      if(isPoss || N == 1) System.out.println("권병장님, 중대장님이 찾으십니다");
      else System.out.println("엄마 나 전역 늦어질 것 같아");
    }
}
