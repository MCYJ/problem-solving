package boj1149;

import java.util.*;

public class Main {
	static int min(int a, int b) {
		return (a > b)?b:a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int distance;
		int RGB[][] = new int[1000][n];
		
		for(int i=0;i<n;i++) {
			RGB[i][0] = sc.nextInt();
			RGB[i][1] = sc.nextInt();
			RGB[i][2] = sc.nextInt();
		}
		
		for(int i=1;i<n;i++) {
			RGB[i][0] += min(RGB[i-1][1], RGB[i-1][2]);
			RGB[i][1] += min(RGB[i-1][0], RGB[i-1][2]);
			RGB[i][2] += min(RGB[i-1][0], RGB[i-1][1]);
		}


		distance = min(RGB[n-1][0], min(RGB[n-1][1], RGB[n-1][2]));
		System.out.println(distance);
	}
}
