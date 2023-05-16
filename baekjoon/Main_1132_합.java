package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1132_합 {
    static class Alpha implements Comparable<Alpha> {
        long weight = 0;
        boolean isFirst = false;
        
        @Override
        public int compareTo(Alpha a) {
            if(weight > a.weight) return 1;
            else if(weight == a.weight) return 0;
            else return -1;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        
        Alpha[] alpha = new Alpha[10];
        for(int i = 0; i < 10; i++){
        	alpha[i] = new Alpha();
        }
        
        for(int i = 0; i < N; i++) {
            String str = in.readLine();
            
            long pow = 1;
            for (int len = str.length(), j = len-1; j >= 0; j--) {
            	int idx = str.charAt(j) - 'A';
                alpha[idx].weight += pow;
                pow *= 10;
            }

            int firstIdx = str.charAt(0) - 'A';
            alpha[firstIdx].isFirst=true;
        }
        
        Arrays.sort(alpha);
        
        long sum = 0;
        boolean[] isUsed = new boolean[10];
        
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < 10; j++){
        		if(isUsed[j] || (j == 0 && alpha[i].isFirst)) continue;
        		
                sum += alpha[i].weight*(long)j;
                isUsed[j] = true;
                break;
            }
        }
        
        System.out.print(sum);
    }
}
