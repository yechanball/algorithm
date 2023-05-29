package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
	static class Road {
	    int to;
	    int time;
	 
	    public Road(int to, int time) {
	        this.to = to;
	        this.time = time;
	    }
	}
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int testCase = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < testCase; tc++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
 
            ArrayList<Road>[] adjList = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<Road>();
            }
 
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(in.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
 
                adjList[S].add(new Road(E, T));
                adjList[E].add(new Road(S, T));
            }
            
            for (int i = 0; i < W; i++) {
            	st = new StringTokenizer(in.readLine());
            	int S = Integer.parseInt(st.nextToken());
            	int E = Integer.parseInt(st.nextToken());
            	int T = Integer.parseInt(st.nextToken());
            	
            	adjList[S].add(new Road(E, -1 * T));
            }
            
            boolean isPoss = bellmanFord(N, adjList);
 
            out.write(isPoss ? "YES\n" : "NO\n");
        }
        out.flush();
        out.close();
    }
 
    public static boolean bellmanFord(int N, ArrayList<Road>[] adjList) {
        int[] times = new int[N+1];
        Arrays.fill(times, 987654321);
        times[1] = 0;
        
        boolean isUpdate = false;
        for (int i = 1; i < N; i++) {
        	isUpdate = false;
 
            for (int curr = 1; curr <= N; curr++) {
                for (Road next : adjList[curr]) {
                    if (times[next.to] > times[curr] + next.time) {
                    	times[next.to] = times[curr] + next.time;
                        isUpdate = true;
                    }
                }
            }

            if (!isUpdate) break;
        }
        
        if (isUpdate) {
        	for (int curr = 1; curr <= N; curr++) {
                for (Road next : adjList[curr]) {
                    if (times[next.to] > times[curr] + next.time) {
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
}
