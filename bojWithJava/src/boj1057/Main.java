package boj1057;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int count = 1;
		if(a<b) {
			while ((a/2+a%2)<(b/2+b%2)) {
				count++;
				a = a/2+a%2;
				b = b/2+b%2;
			}
		}
		else {
			while ((a/2+a%2)>(b/2+b%2)) {
				count++;
				a = a/2+a%2;
				b = b/2+b%2;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
