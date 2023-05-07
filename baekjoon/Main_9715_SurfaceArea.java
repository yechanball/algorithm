package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9715_SurfaceArea {
    public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	int T = Integer.parseInt(in.readLine());
    	for (int tc = 0; tc < T; tc++) {
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		
    		int R = Integer.parseInt(st.nextToken());
    		int C = Integer.parseInt(st.nextToken());
    		int surface = 0;
    		
    		int[][] map = new int[R][C];   	
    		for(int i = 0; i < R; i++) {
    			String str = in.readLine();
    			for(int j = 0; j < C; j++) {
    				map[i][j] = str.charAt(j) - '0';
    				
    				if(map[i][j] != 0) surface++;
    			}
    		}
    		
    		surface *= 2;
    		
    		for(int i = 0; i < R; i++) {
    			surface += map[i][0];
    			for(int j = 1; j < C; j++) {
    				int tmp = map[i][j] - map[i][j-1];
    				if(tmp > 0) surface += tmp;
    				else surface -= tmp;
    			}
    			surface += map[i][C-1];
    		}
    		
    		for(int i = 0; i < C; i++) {
    			surface += map[0][i];
    			for(int j = 1; j < R; j++) {	
    				int tmp = map[j][i] - map[j-1][i];
    				if(tmp > 0) surface += tmp;
    				else surface -= tmp;
    			}
    			surface += map[R-1][i];
    		}
    		
    		out.write(surface+"\n");
		}
    	out.flush();
    	out.close();
    }
}
