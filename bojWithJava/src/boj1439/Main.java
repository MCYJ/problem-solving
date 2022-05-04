package boj1439;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int change = 0;
		
		for(int i=0;i<str.length()-1;i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				change++;
			}
		}
		System.out.println(change/2+change%2);
	}
}
