package boj25304;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = sc.nextInt();
		int n = sc.nextInt();
		
		int price, piece, cal = 0;
		
		for (int i = 0; i < n; i++) {
			price = sc.nextInt();
			piece = sc.nextInt();
			
			cal += price*piece;
		}
		
		if(tot == cal) System.out.println("Yes");
		else System.out.println("No");
		
		sc.close();
	}
}
