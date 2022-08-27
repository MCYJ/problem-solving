package boj10844;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        long arr[][] = new long[num][10];

        for (int i=1; i<10; i++) {
            arr[0][i] = 1;
        }

        for (int i=0; i<num-1; i++) {
            for (int j=0; j<10; j++) {
                if (j == 0) {
                    arr[i+1][1] += arr[i][j];
                    arr[i+1][1] = arr[i+1][1]%1000000000;
                } else if (j < 9) {
                    arr[i+1][j-1] += arr[i][j];
                    arr[i+1][j-1] = arr[i+1][j-1]%1000000000;
                    arr[i+1][j+1] += arr[i][j];
                    arr[i+1][j+1] = arr[i+1][j+1]%1000000000;
                } else {
                    arr[i+1][8] += arr[i][j];
                    arr[i+1][8] = arr[i+1][8]%1000000000;
                }
            }
        }

        long tot = 0;

        for (int i=0; i<10; i++) {
            tot += arr[num-1][i];
            tot %= 1000000000;
        }
        System.out.println(tot);

        sc.close();
    }
}
