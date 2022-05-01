package boj1417;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dasom = sc.nextInt();
		int dasomCount = dasom;
		
		if(n==1) {
			System.out.println(0);
		}
		else {
			int arr[] = new int[n-1];
			for(int i=0;i<arr.length;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			while(dasom <= arr[arr.length - 1]) {
				dasom++;
				// arr 마지막 감소
				arr[arr.length - 1]--; 
				Arrays.sort(arr);
			}
			
			System.out.println(dasom - dasomCount);
		}
		
		
		
		sc.close();
	}
}
