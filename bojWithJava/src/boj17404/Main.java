package boj17404;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int exceptFirstElement[][] = new int[n][3];
        int exceptSecondElement[][] = new int[n][3];
        int exceptThirdElement[][] = new int[n][3];

        int numSequence[][] = new int[n][3];

        for (int i=0; i<n; i++) {
            for (int j=0; j<3; j++) {
                int num = sc.nextInt();

                numSequence[i][j] = num;

                if (i == 0) {
                    exceptFirstElement[i][j] = num;
                    exceptSecondElement[i][j] = num;
                    exceptThirdElement[i][j] = num;
                }
            }
        }
        exceptFirstElement[0][1] = 1001;
        exceptFirstElement[0][2] = 1001;

        exceptSecondElement[0][0] = 1001;
        exceptSecondElement[0][2] = 1001;

        exceptThirdElement[0][0] = 1001;
        exceptThirdElement[0][1] = 1001;

        for (int i=1; i<n; i++) {
            exceptFirstElement[i][0] = numSequence[i][0] + Math.min(exceptFirstElement[i-1][1], exceptFirstElement[i-1][2]);
            exceptFirstElement[i][1] = numSequence[i][1] + Math.min(exceptFirstElement[i-1][0], exceptFirstElement[i-1][2]);
            exceptFirstElement[i][2] = numSequence[i][2] + Math.min(exceptFirstElement[i-1][0], exceptFirstElement[i-1][1]);

            exceptSecondElement[i][0] = numSequence[i][0] + Math.min(exceptSecondElement[i-1][1], exceptSecondElement[i-1][2]);
            exceptSecondElement[i][1] = numSequence[i][1] + Math.min(exceptSecondElement[i-1][0], exceptSecondElement[i-1][2]);
            exceptSecondElement[i][2] = numSequence[i][2] + Math.min(exceptSecondElement[i-1][0], exceptSecondElement[i-1][1]);

            exceptThirdElement[i][0] = numSequence[i][0] + Math.min(exceptThirdElement[i-1][1], exceptThirdElement[i-1][2]);
            exceptThirdElement[i][1] = numSequence[i][1] + Math.min(exceptThirdElement[i-1][0], exceptThirdElement[i-1][2]);
            exceptThirdElement[i][2] = numSequence[i][2] + Math.min(exceptThirdElement[i-1][0], exceptThirdElement[i-1][1]);
        }

        int minOfFirst = Math.min(exceptFirstElement[n-1][1], exceptFirstElement[n-1][2]);
        int minOfSecond = Math.min(exceptSecondElement[n-1][0], exceptSecondElement[n-1][2]);
        int minOfThird = Math.min(exceptThirdElement[n-1][0], exceptThirdElement[n-1][1]);

        int min = Math.min(minOfFirst, Math.min(minOfSecond, minOfThird));

        System.out.println(min);

        sc.close();
    }
}
