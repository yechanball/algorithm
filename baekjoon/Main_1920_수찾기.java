package algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1920_수찾기 {
	public static int bfs(int[] arr, int key){
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while(leftIdx <= rightIdx){
            int midIdx = (leftIdx + rightIdx) / 2;

            if(key < arr[midIdx]){
                rightIdx = midIdx - 1;
            }else if(key > arr[midIdx]){
                leftIdx = midIdx + 1;
            }else{
                return midIdx;
            }
        }
        return -1;
    }
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		
        int i, j;
        int N = sc.nextInt();
        int[] A = new int[N];
        
        for(i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for(i=0; i<M; i++){
            int num = sc.nextInt();
            int exist = bfs(A, num);
            
            if(exist == -1){
                System.out.println("0");
            }else{
                System.out.println("1");
            }
        }
		sc.close();
	}
}