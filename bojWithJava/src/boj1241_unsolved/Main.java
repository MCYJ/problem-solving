package boj1241_unsolved;

import java.util.*;

public class Main {
	static int n;
	static int arr[];
	static int numberOfArr[] = new int[1000001];
	static int numberOfOne = 0;
	static int biggestNum = 0;

	static void setNumberOfArr(int num) {
		// 1울 순회하면 n만큼 돌기 때문에 1은 별도로 갯수로써 추가함
		if(num == 1) {
			numberOfOne++;
			return;
		}
		int i = 1;
		while(num*i<=biggestNum) {
			numberOfArr[num*i]++;
			i++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n+1];
		
		// idx 1부터 저장
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			// 입력된 숫자배열 저장
			arr[i] = num;
			if(num >= biggestNum) biggestNum = num;
		}
		
		for (int i = 1; i <= n; i++) {
			setNumberOfArr(arr[i]);
		}
		
		for (int i = 1; i <= n; i++) {
			// 본인 제거해야하기 때문에 1 빼야함
			System.out.println(numberOfArr[arr[i]] + numberOfOne -1);
		}
		
		sc.close();
	}
}
