package boj2096;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[][] = new int[n][3];
        int maxResult[][] = new int[n][3];
        int minResult[][] = new int[n][3];

        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) {
                arr[i][j] = sc.nextInt();
                if(i == 0){
                    maxResult[i][j] = arr[i][j];
                    minResult[i][j] = arr[i][j];
                }

            }
        }

        for (int i=1; i<n; i++) {
            maxResult[i][0] = arr[i][0] + Math.max(maxResult[i-1][0], maxResult[i-1][1]);
            maxResult[i][1] = arr[i][1] + Math.max(maxResult[i-1][0], Math.max(maxResult[i-1][1], maxResult[i-1][2]));
            maxResult[i][2] = arr[i][2] + Math.max(maxResult[i-1][1], maxResult[i-1][2]);

            minResult[i][0] = arr[i][0] + Math.min(minResult[i-1][0], minResult[i-1][1]);
            minResult[i][1] = arr[i][1] + Math.min(minResult[i-1][0], Math.min(minResult[i-1][1], minResult[i-1][2]));
            minResult[i][2] = arr[i][2] + Math.min(minResult[i-1][1], minResult[i-1][2]);
        }

        int max = Math.max(maxResult[n-1][0], Math.max(maxResult[n-1][1], maxResult[n-1][2]));
        int min = Math.min(minResult[n-1][0], Math.min(minResult[n-1][1], minResult[n-1][2]));

        System.out.println(max+" "+min);

        sc.close();
    }
}
