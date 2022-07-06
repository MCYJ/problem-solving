package boj11404;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[][] = new int[num][num];
        int m = sc.nextInt();
        for (int i=0; i<num; i++) {
            Arrays.fill(arr[i], 10000000);
            arr[i][i] = 0;
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();

            arr[a-1][b-1] = Math.min(w, arr[a-1][b-1]);
        }

        for (int k=0; k<num; k++) {
            for (int i=0; i<num; i++) {
                for (int j=0; j<num; j++) {
                    if(i == j) arr[i][j] = 0;
                    else arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int i=0; i<num; i++) {
            for (int j=0; j<num; j++) {
                if(arr[i][j] == 10000000) System.out.print(0+" ");
                else System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
