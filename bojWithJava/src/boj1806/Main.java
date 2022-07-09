package boj1806;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 최소길이
        int min = Integer.MAX_VALUE;
        int n = sc.nextInt();
        int s = sc.nextInt();
        int arr[] = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0, end = 0;
        int total = 0;

        while (start<n && end<n) {

            while (end<n && total < s) {
                total += arr[end];
                end++;
            }


            if(end==n+1) break;

            min = Math.min(min, end-start);

            // start가 다음 요소를 가리키는 경우 부분합에서 제거
            while (start<n && total >= s) {
                total -= arr[start];
                start++;
                if(total >= s){
                    min = Math.min(min, end-start);
                }
            }
        }

        // 그런 수가 없는 경우
        if(min == Integer.MAX_VALUE) System.out.println(0);
        // total이 s에 도달하지 못하는 경우
        else if(start == 0) System.out.println(0);
        else System.out.println(min);

        sc.close();
    }
}
