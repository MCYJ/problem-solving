package boj7579;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfApps = sc.nextInt();
        int byteNeeded = sc.nextInt();

        int listOfByte[] = new int[numOfApps+1];
        int listOfCost[] = new int[numOfApps+1];
        int maxOfByte = 0;
        int totalOfCost = 0;

        for (int i=1; i<=numOfApps; i++) {
            int byteOfApp = sc.nextInt();
            listOfByte[i] = byteOfApp;
            maxOfByte += byteOfApp;
        }

        for (int i=1; i<=numOfApps; i++) {
            int costOfApp = sc.nextInt();
            listOfCost[i] = costOfApp;
            totalOfCost += costOfApp;
        }
        maxOfByte -= byteNeeded;

        int costMat[][] = new int[numOfApps+1][totalOfCost+1];

        for (int i=0; i<numOfApps; i++) {
            for (int j=0; j<=totalOfCost; j++) {
                // i+1 를 선택한 경우
                if (j-listOfCost[i+1] >= 0) {
                    costMat[i+1][j] = Math.max(costMat[i+1][j], costMat[i][j-listOfCost[i+1]] + listOfByte[i+1]);
                }
                // i+1 를 선택하지 않은 경우
                costMat[i+1][j] = Math.max(costMat[i][j], costMat[i+1][j]);
            }
        }

        for (int i=0; i<=totalOfCost; i++) {
            for (int j=0; j<=numOfApps; j++) {
                if (costMat[j][i] >= byteNeeded) {
                    System.out.println(i);
                    return;
                }
            }
        }
        /*

        for (int i=0; i<=numOfApps; i++) {
            for (int j=0; j<=totalOfCost; j++) {
                System.out.print( costMat[i][j]+" ");
            }
            System.out.println();
        }
         */

        sc.close();
    }
}
