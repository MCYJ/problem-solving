package boj1068;

import java.util.*;

public class Main {
	// leaf 상태 : 초기에는 모두 0
	static int leaf[];
	// arr 모든 값 저장
	static int arr[];
	
	static int del;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tot = sc.nextInt();
		arr = new int[tot];
		leaf = new int[tot];
		Arrays.fill(leaf, 1);
		for (int i = 0; i < tot; i++) {
			arr[i] = sc.nextInt();
		}
		del = sc.nextInt();
		
		for (int i = 0; i <  arr.length; i++) {
			int idx = i;
			while(arr[idx] != -1) {
				idx = arr[idx];
				leaf[idx] = 0;
			}
		}
		
		for (int i = 0; i < leaf.length; i++) {
			System.out.println(leaf[i]);
		}
		
		
		sc.close();
	}
}
