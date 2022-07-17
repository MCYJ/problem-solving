package boj1789;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long tot = 0;
        long k = 1;

        while (tot + k < n) {
            tot += k;
            k++;
        }
        if (tot+k > n) {
            System.out.println(k - 1);
        } else {
            System.out.println(k);
        }

        sc.close();
    }
}
