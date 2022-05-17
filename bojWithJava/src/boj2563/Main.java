package boj2563;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int paperMat[][] = new int[101][101];
		
		for(int i = 0;i<101;i++)
			Arrays.fill(paperMat[i], 0);
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j=x+1;j<=x+10;j++) {
				for(int k=y+1;k<=y+10;k++) {
					paperMat[j][k] = 1;
				}
			}
		}
		int count=0;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(paperMat[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
