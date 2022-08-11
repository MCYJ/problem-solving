package boj1912;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n+1];
        int max = 0;

        for (int i=1; i<=n; i++) {
            arr[i] = sc.nextInt();
            if(i == 1) max = arr[i];
        }

        for (int i=1; i<=n; i++) {
            if (arr[i-1] + arr[i] > arr[i]) arr[i] += arr[i-1];
            max = Math.max(max, arr[i]);
        }

        System.out.println(max);

        sc.close();
    }
}
