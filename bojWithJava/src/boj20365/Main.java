package boj20365;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfB = 0, numOfR = 0;
        int length = sc.nextInt();

        String str = sc.next();
        int i = 0;
        while (i < length) {
            boolean isB = false;
            while (i < length && str.charAt(i) == 'B') {
                i++;
                isB = true;
            }
            if (isB) numOfB++;

            boolean isR = false;
            while (i < length && str.charAt(i) == 'R') {
                i++;
                isR = true;
            }
            if (isR) numOfR++;
        }
        if (numOfB == numOfR) {
            System.out.println(numOfB + 1);
        } else {
            int num = (numOfB > numOfR) ? numOfB : numOfR;
            System.out.println(num);
        }

        sc.close();
    }
}
