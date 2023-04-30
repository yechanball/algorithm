package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_8117_Triangles {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> segments = new ArrayList<>();
        
        while (true) {
            int segment = Integer.parseInt(in.readLine());
            if (segment == 0) break;
            segments.add(segment);
        }
        int size = segments.size();

        if (size < 3) {
            System.out.print("NIE");
        } else {
            boolean foundTriangle = false;
            
            for (int i = 0; i < size-2 && !foundTriangle; i++) {
                for (int j = i + 1; j < size-1 && !foundTriangle; j++) {
                    for (int k = j + 1; k < size; k++) {
                        int a = segments.get(i);
                        int b = segments.get(j);
                        int c = segments.get(k);
                        
                        if (isTriangle(a, b, c)) {
                            System.out.print(a + " " + b + " " + c);
                            foundTriangle = true;
                            break;
                        }
                    }
                }
            }

            if (!foundTriangle) System.out.print("NIE");
        }
    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }
}
