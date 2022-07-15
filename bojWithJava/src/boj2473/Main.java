package boj2473;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long arr[] = new long[n];

        // 배열 값 입력
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextLong();
        }
        // 배열 정렬
        Arrays.sort(arr);
        long distance = Long.MAX_VALUE;
        // 세 용액 저장 위한 배열 선언
        long chem[] = new long[3];
        // key 값을 기준으로 순회
        for (int i=0; i<n-2; i++) {
            long key = arr[i];
            int left = i+1;
            int right = n-1;

            // left 인덱스가 right를 앞지르는 순간 순회 끝
            while (left < right) {
                long tot = key + arr[left] + arr[right];
                if (distance > Math.abs(tot)) {
                    // distance에 tot반영
                    distance = Math.abs(tot);
                    chem[0] = key;
                    chem[1] = arr[left];
                    chem[2] = arr[right];
                }
                // tot == 0 인경우 바로 해당 요소 출력 후 return
                if (tot == 0) {
                    System.out.println(chem[0]+" "+chem[1]+" "+chem[2]);
                    return;
                }
                if (tot > 0) {
                    right--;
                } else {
                    left++;
                }
            }


        }
        System.out.println(chem[0]+" "+chem[1]+" "+chem[2]);
        sc.close();
    }
}
