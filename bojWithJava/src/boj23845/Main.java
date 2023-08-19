package boj23845;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];
        // 배열별로 입력
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        // 배열 정렬
        Arrays.sort(arr);
        // 마트료시카 / 총수익 합계 초기화
        long numOfMatro = 1;
        long tot = 0;
        // n == 1 인경우
        if (n == 1) {
            System.out.println(arr[0]);
            return;
        }
        long criteria = arr[0];
        // 모든 배열의 순회 / 마지막 인덱스는 반복문 내부엥서 순회
        for (int i=0; i<n-1; i++) {
            if (criteria+1 == arr[i+1]) {
                criteria++;
                numOfMatro++;
                if (i+2 == n) {
                    tot += criteria*numOfMatro;
                }
            } else if (arr[i] == arr[i + 1]) {
                tot += arr[i];
                if (i+2 == n) {
                    tot += arr[i+1]*numOfMatro;
                }
            } else {
                tot += arr[i]*numOfMatro;
                criteria = arr[i+1];
                if (i+2 == n) {
                    tot += arr[i+1];
                }
                numOfMatro = 1;
            }
        }

        // 수익 출력
        System.out.println(tot);

        sc.close();
    }
}
