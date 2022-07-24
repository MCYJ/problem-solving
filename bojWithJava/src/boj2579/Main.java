package boj2579;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfStep = sc.nextInt();
        int listOfStep[] = new int[numOfStep+1];
        int tableOfStep[][] = new int[numOfStep+1][3];

        for (int i=1; i<=numOfStep; i++) {
            listOfStep[i] = sc.nextInt();
        }
        // numOfStep 1 / 2 인 경우
        if (numOfStep == 1) {
            System.out.println(listOfStep[1]);
            return;
        } else if (numOfStep == 2) {
            System.out.println(listOfStep[1] + listOfStep[2]);
            return;
        }

        tableOfStep[1][1] = listOfStep[1];
        tableOfStep[1][2] = 0;
        tableOfStep[2][1] = listOfStep[2];
        tableOfStep[2][2] = listOfStep[1] + listOfStep[2];
        for (int i=3; i<=numOfStep; i++) {
            tableOfStep[i][1] = Math.max(tableOfStep[i-2][1], tableOfStep[i-2][2]) + listOfStep[i];
            tableOfStep[i][2] = tableOfStep[i-1][1] + listOfStep[i];
        }

        System.out.println(Math.max(tableOfStep[numOfStep][1], tableOfStep[numOfStep][2]));





        sc.close();
    }
}
