package boj9655;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // SK 여부
        boolean isSK = false;

        while (num != 0) {
            if (num >= 3) num -= 3;
            else num -= 1;
            isSK = !isSK;
        }

        if (isSK) System.out.println("SK");
        else System.out.println("CY");

        sc.close();
    }
}
