package boj25332_unsolved;

import java.util.*;

// 시간초과

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        // 숫자리스트 생성
        long listA[] = new long[length];
        long listB[] = new long[length];

        // 누적리스트 생성
        long cumListA[] = new long[length+1];
        long cumListB[] = new long[length+1];

        long totA = 0;
        long totB = 0;

        for (int i=0; i<length; i++) {
            listA[i] = sc.nextLong();
            totA += listA[i];
            cumListA[i+1] = totA;
        }
        for (int i=0; i<length; i++) {
            listB[i] = sc.nextLong();
            totB += listB[i];
            cumListB[i+1] = totB;
        }

        long sameCase = 0;

        for (int i=1; i<=length; i++) {
            for (int j=0; j<i; j++) {
                if (cumListA[i] - cumListA[j] == cumListB[i] - cumListB[j]) sameCase++;
            }
        }

        System.out.println(sameCase);

        sc.close();
    }
}
