package boj18234;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        long arr[] = new long[n];
        long tot = 0;
        for (int i=0; i<n; i++) {
            long num = sc.nextLong();
            tot += num;
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        for (int i=0; i<n; i++) {
            tot += arr[i]*(t-n+i);
        }

        System.out.println(tot);
        sc.close();
    }
}
