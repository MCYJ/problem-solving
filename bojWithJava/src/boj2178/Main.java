package boj2178;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dR[] = {-1,1,0,0};
        int dC[] = {0,0,-1,1};

        int date = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Integer> qN = new LinkedList<>();
        Queue<Integer> qM = new LinkedList<>();

        int arr[][] = new int[n][m];

        for (int i=0; i<n; i++) {
            char line[] = sc.next().toCharArray();
            for (int j=0; j<m; j++) {
                /*
                if (line[j]-48 == 1) {
                    qN.add(i);
                    qM.add(j);
                }

                */
                arr[i][j] = line[j]-48;
            }
        }
        qM.add(0);
        qN.add(0);
        qM.add(-1);
        qN.add(-1);

        while (!qN.isEmpty()) {
            int nowN = qN.poll();
            int nowM = qM.poll();

            if (nowM == -1) {
                if (qM.isEmpty()) break;
                qN.add(-1);
                qM.add(-1);
                date++;
            }

            for (int i=0; i<4; i++) {
                int nextN = nowN + dR[i];
                int nextM = nowM + dC[i];

                if (nextM < 0 || nextM >= m || nextN < 0 || nextN >= n) continue;
                if (arr[nextN][nextM] == 0) continue;
                if (nextN == n-1 && nextM == m-1) {
                    date++;
                    System.out.println(date+1);
                    return;
                }
                arr[nextN][nextM] = 0;
                qN.add(nextN);
                qM.add(nextM);
            }
        }

        System.out.println(date);

        sc.close();
    }
}
