package boj1049;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int string = sc.nextInt();
		int n = sc.nextInt();
		int sixString=1001, oneString=1001;
		int sixTemp, oneTemp;
		
		for(int i=0;i<n;i++) {
			sixTemp = sc.nextInt();
			if(sixString > sixTemp) sixString = sixTemp;
			oneTemp = sc.nextInt();
			if(oneString > oneTemp) oneString = oneTemp;
		}
		
		int result1 = (string/6)*sixString+(string%6)*oneString;
		int result2 = (string/6+1)*sixString;
		int result3 = string*oneString;
		
		if(result1 < result2) {
			if(result1 < result3) System.out.println(result1);
			else System.out.println(result3);
		}
		else {
			if(result2 < result3) System.out.println(result2);
			else System.out.println(result3);
		}
		
		sc.close();
	}
}
