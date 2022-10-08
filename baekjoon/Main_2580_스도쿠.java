package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	static int N = 9; // N : 스도쿠 가로 세로 크기
	static int[][] board = new int[N+1][N+1]; // 주어진 보드
	static boolean[][] rowCheck = new boolean[N+1][N+1]; // 가로에서 사용한 숫자 체크
	static boolean[][] colCheck = new boolean[N+1][N+1]; // 세로에서 사용한 숫자 체크
	static boolean[][] subCheck = new boolean[N+1][N+1]; // 3X3 크키에서 사용한 숫자 체크
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if (board[i][j] != 0) { // 빈 칸이 아닌 경우 사용한 숫자 체크해주기
	                rowCheck[i][board[i][j]] = true;
	                colCheck[j][board[i][j]] = true;
	                subCheck[subArr(i,j)][board[i][j]] = true;
	            }
			}
		}
		
		solve(0); // 스도쿠 해결 시작
		
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
	}
	
	static int subArr(int row, int col) { // 3X3 부분 배열 순서 반환
	    return (row/3)*3 + (col/3);
	}
	
	static boolean solve(int cnt) {
	    if (cnt == 81) { // 9X9, 총 81칸을 모두 체크한 경우 종료
	        return true;
	    }
	    
	    int row = cnt / N; // cnt 순서를 행, 열로 변환
	    int col = cnt % N;
	    
	    if (board[row][col] != 0) { // 빈칸이 아닌 경우 다음 칸으로 이동
	    	return solve(cnt+1);
	    }
	    else { // 빈칸인 경우
	        for (int i=1; i<=9; i++) { // 1부터 9까지 체크
	            if (!rowCheck[row][i] && !colCheck[col][i] && !subCheck[subArr(row,col)][i]) { // 가로, 세로, 부분배열에서 사용하지 않은 숫자인 경우 체크 후 재귀 호출
	            	board[row][col] = i;
	                rowCheck[row][i] = true;
	                colCheck[col][i] = true;
	                subCheck[subArr(row,col)][i] = true;
	                
	                if (solve(cnt+1)) { // 다음 칸 체크한 결과가 가능한 경우에만 true 반환
	                    return true;
	                }
	                
	                board[row][col] = 0;
	                rowCheck[row][i] = false;
	                colCheck[col][i] = false;
	                subCheck[subArr(row,col)][i] = false;
	            }
	        }
	    }
	    return false;
	}
}
