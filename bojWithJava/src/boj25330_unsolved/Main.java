package boj25330_unsolved;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 몬스터의 수
        int n = sc.nextInt();
        // 시루의 초기체력
        int k = sc.nextInt();
        int dp[][] = new int[n][k];
        // 몬스터의 공격력
        int weight[] = new int[n];

        // 주민들의 수
        int value[] = new int[n];

        for (int i=0; i<n; i++) weight[i] = sc.nextInt();
        for (int i=0; i<n; i++) value[i] = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int w=0; w<k; w++) {
                // 해당 마을을 선택한 경우
                if (w - weight[w] >= 0) {

                }
                // 해당 마을을 선택하지 않은 경우

            }
        }


        sc.close();
    }
}
