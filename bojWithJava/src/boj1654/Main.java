package boj1654;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int tot = 0;
		int length = arr[arr.length-1];
		while(tot<k) {
			tot = 0;
			for(int i=0;i<n;i++) {
				tot += arr[i]/length;
			}
			length--;
		}
		System.out.println(++length);
		sc.close();
	}
}
