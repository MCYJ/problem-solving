package boj10026;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int visited[][] = new int[n][n];
        String str[] = new String[n];

        int dR[] = {-1,1,0,0};
        int dC[] = {0,0,-1,1};

        int rgNum = 0;
        int bNum = 0;

        for (int i=0; i<n; i++) {
            str[i] = sc.next();
        }

        // queue선언
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qC = new LinkedList<>();
        for (int j=0; j<n; j++) {
            for (int k=0; k<n; k++) {
                if (visited[j][k] == 1) continue;

                // 방문하지 않은 모든 포인트를 다 q에 넣음
                qR.add(j);
                qC.add(k);

                char ch = str[j].charAt(k);

                // 구역숫자 증가
                if (ch == 'R' || ch == 'G') rgNum++;
                else bNum++;

                while (!qR.isEmpty()) {
                    int nowR = qR.poll();
                    int nowC = qC.poll();

                    for (int i=0; i<4; i++) {
                        int nextR = nowR + dR[i];
                        int nextC = nowC + dC[i];

                        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
                        if (visited[nextR][nextC] == 1) continue;
                        // 현재 문자랑 동일하지 않은 경우
                        if (ch == 'B') {
                            if (str[nextR].charAt(nextC) != ch) continue;
                        } else {
                            if (str[nextR].charAt(nextC) == 'B') continue;
                        }

                        visited[nextR][nextC] = 1;
                        qR.add(nextR);
                        qC.add(nextC);

                    }
                }
            }
        }

        int disableNum = bNum + rgNum;

        // ableNum
        int ableNum = 0;
        visited = new int[n][n];
        for (int j=0; j<n; j++) {
            for (int k=0; k<n; k++) {
                if (visited[j][k] == 1) continue;

                // 방문하지 않은 모든 포인트를 다 q에 넣음
                qR.add(j);
                qC.add(k);

                char ch = str[j].charAt(k);

                // 구역숫자 증가
                ableNum++;

                while (!qR.isEmpty()) {
                    int nowR = qR.poll();
                    int nowC = qC.poll();

                    for (int i=0; i<4; i++) {
                        int nextR = nowR + dR[i];
                        int nextC = nowC + dC[i];

                        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
                        if (visited[nextR][nextC] == 1) continue;
                        // 현재 문자랑 동일하지 않은 경우
                        if (str[nextR].charAt(nextC) != ch) continue;

                        visited[nextR][nextC] = 1;
                        qR.add(nextR);
                        qC.add(nextC);

                    }
                }
            }
        }

        System.out.println(ableNum+" "+disableNum);

        sc.close();
    }
}
