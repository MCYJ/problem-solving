package boj1015;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		int b[] = new int[n];
		for(int i=0;i<n;i++) {
			b[i] = sc.nextInt();
		}
		int tot = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int i=0;i<n;i++) {
			tot += a[i]*b[n-1-i];
		}
		System.out.println(tot);
		
		sc.close();
	}
}
