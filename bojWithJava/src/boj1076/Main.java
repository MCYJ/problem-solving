package boj1076;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String firstCol, secondCol, thirdCol;
		long result;
		
		firstCol = sc.next();
		secondCol = sc.next();
		thirdCol = sc.next();
		
		result = (getNum(firstCol)*10+getNum(secondCol))*(long)Math.pow(10, getNum(thirdCol));
		System.out.println(result);
		
		sc.close();
	}
	
	static long getNum(String str) {
		switch (str) {
		case "black":
			return 0;
		case "brown":
			return 1;
		case "red":
			return 2;
		case "orange":
			return 3;
		case "yellow":
			return 4;
		case "green":
			return 5;
		case "blue":
			return 6;
		case "violet":
			return 7;
		case "grey":
			return 8;
		case "white":
			return 9;
		}
		return 0;
	}
}
