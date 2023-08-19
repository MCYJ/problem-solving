package boj2156;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[] = new int[num];

        for (int i=0; i<num; i++) {
            arr[i] = sc.nextInt();
        }

        int arrMat[][] = new int[num][2];

        if (num == 1){
            System.out.println(arr[0]);
            return;
        }
        if (num == 2) {
            System.out.println(arr[0]+arr[1]);
            return;
        }
        int tot = 0;
        arrMat[0][0] = arr[0];
        arrMat[0][1] = arr[0];
        if (arr[1] == 0) {
            arrMat[1][0] = arr[0];
            arrMat[1][1] = arr[0];
        } else {
            arrMat[1][0] = arr[1];
            arrMat[1][1] = arr[0] + arr[1];
        }

        tot = arrMat[1][1];

        for (int i=2; i<num; i++) {
            if (arr[i] == 0) {
                arrMat[i][0] = Math.max(arrMat[i - 1][0], arrMat[i - 1][1]);
                arrMat[i][1] = Math.max(arrMat[i - 1][0], arrMat[i - 1][1]);
            } else {
                arrMat[i][0] = arr[i] + Math.max(arrMat[i-2][1], arrMat[i-2][0]);
                arrMat[i][1] = arr[i] + arrMat[i-1][0];
            }

            tot = Math.max(tot, Math.max(arrMat[i][0], arrMat[i][1]));
        }

        System.out.println(tot);

        sc.close();
    }
}
