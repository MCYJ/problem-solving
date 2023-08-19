package boj1011;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int listX[] = new int[t];
        int listY[] = new int[t];
        int biggest = 1;
        for (int i=0; i<t; i++) {
            listX[i] = sc.nextInt();
            listY[i] = sc.nextInt();

            biggest = Math.max(biggest, listY[i] - listX[i]);
        }

        int result[] = new int[biggest+1];

        for (int i=3; i<biggest; i++) {
        //    result[i] = num;
        }

        sc.close();
    }
}
