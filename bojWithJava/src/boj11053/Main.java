package boj11053;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int s[] = new int[n+1];
        int d[] = new int[n+1];
        int max = 0;

        for (int i=1; i<=n; i++) {
            s[i] = sc.nextInt();
        }

        for (int i=1; i<=n; i++) {
            max = 0;
            for (int j=1; j<=i; j++) {
                if (s[j] < s[i]) {
                    max = Math.max(max, d[j]);
                }
            }
            d[i] = max+1;
        }

        for (int i=1; i<=n; i++) {
            max = Math.max(max, d[i]);
        }

        System.out.println(max);

        sc.close();
    }
}
