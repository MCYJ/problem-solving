package boj14916;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int arr[] = new int[num + 1];

        Arrays.fill(arr, 100000);

        if (num <= 5) {
            switch (num) {
                case 1:
                    System.out.println(-1);
                    break;
                case 2:
                    System.out.println(1);
                    break;
                case 3:
                    System.out.println(-1);
                    break;
                case 4:
                    System.out.println(2);
                    break;
                case 5:
                    System.out.println(1);
                    break;
            }
            return;
        }
        arr[2] = 1;
        arr[4] = 2;
        arr[5] = 1;

        int idx = 6;
        while (idx <= num) {
            arr[idx] = Math.min(arr[idx-2]+1, arr[idx]);
            arr[idx] = Math.min(arr[idx-5]+1, arr[idx]);
            idx++;
        }

        if (arr[num] == 100000) System.out.println(-1);
        else System.out.println(arr[num]);

        sc.close();
    }
}
