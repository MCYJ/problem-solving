package boj1436;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, tot = 0, number = 666;
		
		n = sc.nextInt();
		
		while(tot < n) {
			if (isSix(number)) {
				tot++;
			}
				
			number++;
		}
		System.out.println(--number);
		sc.close();
	}
	static boolean isSix(int number) {
		String str_number = Integer.toString(number);
		for(int i=0;i<(str_number.length())-2;i++) {
			if((str_number.charAt(i) == '6') && (str_number.charAt(i+1) == '6') && (str_number.charAt(i+2) == '6')) {
				return true;
			}
		}
		return false;
	}
}
