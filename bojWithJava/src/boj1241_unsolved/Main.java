package boj1241_unsolved;

import java.util.*;

public class Main {
	static int n;
	static int arr[];
	static int numberOfArr[] = new int[1000001];
	static int numberOfOne = 0;
	static int biggestNum = 0;

	static void setNumberOfArr(int num) {
		// 1�� ��ȸ�ϸ� n��ŭ ���� ������ 1�� ������ �����ν� �߰���
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
		
		// idx 1���� ����
		for (int i = 1; i <= n; i++) {
			int num = sc.nextInt();
			// �Էµ� ���ڹ迭 ����
			arr[i] = num;
			if(num >= biggestNum) biggestNum = num;
		}
		
		for (int i = 1; i <= n; i++) {
			setNumberOfArr(arr[i]);
		}
		
		for (int i = 1; i <= n; i++) {
			// ���� �����ؾ��ϱ� ������ 1 ������
			System.out.println(numberOfArr[arr[i]] + numberOfOne -1);
		}
		
		sc.close();
	}
}
