package boj1697;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
            return;
        }

        int sec = 0;
        int length = 0;
        int arr[] = new int[200001];
        q.add(n);
        q.add(-1);

        while (!q.isEmpty()) {
            int nowN = q.poll();
            int dN[] = {-1, 1, nowN};
            if (nowN == -1) {
                length++;
                if (q.isEmpty()) break;
                q.add(-1);
            } else {
                for (int i=0; i<3; i++) {
                    int nextN = nowN + dN[i];

                    if (nextN < 0 || nextN >= 200001) continue;
                    if (arr[nextN] == 1) continue;
                    if (nextN == k) {
                        System.out.println(length+1);
                        return;
                    }
                    arr[nextN] = 1;
                    q.add(nextN);
                }
            }

        }

        System.out.println(length);

        sc.close();
    }
}
