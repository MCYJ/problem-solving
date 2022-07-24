package boj11659;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int arr[] = new int[n];
        int prefixSum[] = new int[n+1];

        int result[] = new int[m+1];
        int tot = 0;

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            tot += arr[i];
            prefixSum[i+1] = tot;
        }

        for (int i=0; i<m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            result[i] = prefixSum[end] - prefixSum[start-1];
        }

        for (int i=0; i<m; i++) {
            System.out.println(result[i]);
        }

        sc.close();
    }
}
