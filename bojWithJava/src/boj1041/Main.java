package boj1041;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int dice[] = new int[6];
		long firstSmallestNum = Integer.MAX_VALUE;
		long firstSmallestIdx = 0;
		long secondSmallestNum = Integer.MAX_VALUE;
		long secondSmallestIdx = 0;
		long thirdSmallestNum = Integer.MAX_VALUE;
		long thirdSmallestIdx = 0;
		// n = 1 / n = 2 반영
		
		
		// 가장 작은 값 구하기
		for (int i = 0; i < dice.length; i++) {
			dice[i] = sc.nextInt();
			if(dice[i] < firstSmallestNum) { 
				firstSmallestNum = dice[i];
				firstSmallestIdx = i;
			}
		}
		// 두번째로 작은 값 구하기
		for (int i = 0; i < dice.length; i++) {
			if(firstSmallestIdx != i && (5-firstSmallestIdx) != i && dice[i] < secondSmallestNum) {
				
				secondSmallestNum = dice[i];
				secondSmallestIdx = i;
			}
		}
		// 세번째로 작은 값 구하기
		for (int i = 0; i < dice.length; i++) {
			if(firstSmallestIdx != i && 5-firstSmallestIdx != i 
					&& secondSmallestIdx != i && 5-secondSmallestIdx != i 
					&& dice[i] < thirdSmallestNum) {
				thirdSmallestNum = dice[i];
				thirdSmallestIdx = i;
			}
		}
		long smallestNum = 0;
		if(n==1) {
			long biggestNum = 0;
			long biggestIdx = 0;
			for (int i = 0; i < dice.length; i++) {
				if(biggestNum < dice[i]) {
					biggestNum = dice[i];
					biggestIdx = i;
				}
			}
			for (int i = 0; i < dice.length; i++) {
				if(biggestIdx != i) smallestNum += dice[i];
			}
		}
		else if(n==2) {
			smallestNum = (firstSmallestNum+secondSmallestNum)*4 + (firstSmallestNum+secondSmallestNum+thirdSmallestNum)*4;
		}
		else {
			smallestNum = firstSmallestNum*(n-2)*(n-1)*4 + firstSmallestNum*(n-2)*(n-2) + (firstSmallestNum+secondSmallestNum)*(n-1)*4
					+ (firstSmallestNum+secondSmallestNum)*(n-2)*4
					+ (firstSmallestNum+secondSmallestNum+thirdSmallestNum)*4;
		}
		
		System.out.println(smallestNum);
		
		sc.close();
	}
}
