package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_25206_너의평점은 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Double> gradeMap = new HashMap<>();
		gradeMap.put("A+", 4.5);
		gradeMap.put("A0", 4.0);
		gradeMap.put("B+", 3.5);
		gradeMap.put("B0", 3.0);
		gradeMap.put("C+", 2.5);
		gradeMap.put("C0", 2.0);
		gradeMap.put("D+", 1.5);
		gradeMap.put("D0", 1.0);
		gradeMap.put("F", 0.0);
		gradeMap.put("P", 0.0);

		double totalGrade = 0, totalScore = 0;
		for (int i = 0; i < 20; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			totalGrade += score * gradeMap.get(grade);
			if(!grade.equals("P")){
				totalScore += score;
			}
		}

		System.out.printf("%.6f", totalGrade/totalScore);
	}
}
