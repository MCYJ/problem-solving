package boj1052;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int div = 2;
		
		while (n > k) {
			k *= 2;
		}
		System.out.println(k +" "+n);
		
		sc.close();
	}
}
