package boj1263;

import java.util.*;

public class Main {
	static int listOfTime[] = new int[1000001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			int s = sc.nextInt();
			
			listOfTime[s] += t;
		}
		
		int flagTime = 1000000;
		
		for (int i = 1000000; i >= 0 ; i--) {
			// listoftime에 값이 존재할 경우
			if(listOfTime[i] > 0) {
				if(i<flagTime) {
					flagTime = i;
				}
				
				flagTime -= listOfTime[i];
				if(flagTime < 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(flagTime);

		sc.close();
	}
}
