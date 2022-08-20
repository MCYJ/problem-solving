package boj13305;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfCity = sc.nextInt();
        long listOfLength[] = new long[numOfCity-1];
        long listOfPrice[] = new long[numOfCity];

        for (int i=0; i<numOfCity-1; i++) {
            listOfLength[i] = sc.nextLong();
        }

        for (int i=0; i<numOfCity; i++) {
            listOfPrice[i] = sc.nextLong();
        }

        if (numOfCity == 2) {
            System.out.println(listOfLength[0]*listOfPrice[0]);
            return;
        }

        long totalPrice = 0;
        long price = listOfPrice[0];
        long length = listOfLength[0];

        totalPrice = price*length;

        for (int i=1; i<numOfCity-1; i++) {
            if (price > listOfPrice[i]) price = listOfPrice[i];
            totalPrice += price*listOfLength[i];
        }

        System.out.println(totalPrice);

        sc.close();
    }
}
