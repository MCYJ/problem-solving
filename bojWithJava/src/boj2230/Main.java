package boj2230;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 배열생성
        int arr[] = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        // start / end 값 설정이 잘못된 거 같은데....
        int start = 0, end = 0;
        // 배열 정렬부터
        Arrays.sort(arr);


        // start가 모든 배열의 순회를 마칠 때까지
        for (;start<n;start++) {
            while (end<n && arr[end] - arr[start] < m) {
                end++;
            }
            if (end == n) break;
            min = Math.min(min, arr[end] - arr[start]);
        }

        System.out.println(min);

        sc.close();
    }
}
