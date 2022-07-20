package boj11047;

// 11047 : 동전0

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        int result[] = new int[100000001];
        Arrays.fill(result, Integer.MAX_VALUE);

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            result[arr[i]] = 1;
        }

        for (int i=1; i<=k; i++) {
            for (int j=0; j<n; j++) {
                if (i - arr[j] < 1) continue;
                result[i] = Math.min(result[i], result[i - arr[j]] + 1);
            }
        }

        System.out.println(result[k]);

        sc.close();
    }
}
