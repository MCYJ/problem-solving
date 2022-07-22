package boj11727;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long arr[] = new long[n+1];

        if (n == 1) {
            System.out.println(1);
            return;
        }
        else if (n == 2) {
            System.out.println(3);
            return;
        }
        arr[1] = 1;
        arr[2] = 3;

        for (int i=3; i<=n; i++) {
            arr[i] = arr[i-1] + arr[i-2]*2;
            if (arr[i] >= 10007) arr[i] %= 10007;
        }

        System.out.println(arr[n]);

        sc.close();
    }
}
