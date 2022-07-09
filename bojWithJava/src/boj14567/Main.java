package boj14567;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int degreeList[] = new int[n+1];
		int abList[][] = new int[m][2];

		Arrays.fill(degreeList, 1);
		

		
		// edge matrix »ý¼º
		for (int i = 0; i < m; i++) {			
			abList[i][0] = sc.nextInt();
			abList[i][1] = sc.nextInt();
		}
		Arrays.sort(abList, (a,b) -> a[0] - b[0]);
		
		for(int i=0;i<abList.length;i++) {
			System.out.println(abList[i][0]+" "+abList[i][1]);
		}
		
		sc.close();
	}
}
