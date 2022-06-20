package boj1105;

import java.util.*;

public class Main {
	static int getCountEight(int num) {
		int count = 0;
		
		while(num > 0) {
			if(num%10 == 8) count++;
			num /= 10;
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		int r = sc.nextInt();
		
		int count = Integer.MAX_VALUE;
		
		for(int i=l;i<=r;i++) {
			if (getCountEight(i) < count) {
				count = getCountEight(i);
			}
		}
		System.out.println(count);
		sc.close();
	}
}
