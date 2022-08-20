package boj1644;

import java.util.*;

public class Main {
    static int arr[];
    static int n;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listOfPrime = new ArrayList<>();
        // 소수의 갯수
        int numberOfPrime = 0;
        n = sc.nextInt();

        arr = new int[n+1];
        Arrays.fill(arr, 1);
        arr[0] = 0;
        arr[1] = 0;

        // eratos
        for (int i=2; i<=n; i++) {
            int temp = i;
            if (arr[i] == 1)
                listOfPrime.add(i);
            else
                continue;
            while (temp <= n) {
                arr[temp] = 0;
                temp += i;
            }
        }


        int start = 0;
        int end = 0;

        int tot = 0;

        while (start < listOfPrime.size() && end < listOfPrime.size()) {
            while (start < listOfPrime.size() && tot <= n) {
                if (tot == n) {
                    numberOfPrime++;
                }
                tot += listOfPrime.get(start);
                start++;
            }

            while (end < listOfPrime.size() && tot >= n) {
                if (tot == n) {
                    numberOfPrime++;
                }
                tot -= listOfPrime.get(end);
                end++;
            }

        }


        if(n == 1)
            System.out.println(0);
        else
            System.out.println(numberOfPrime);

        sc.close();
    }
}
