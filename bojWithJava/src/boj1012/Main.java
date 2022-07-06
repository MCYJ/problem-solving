package boj1012;

import java.util.*;

public class Main {
    static int moveR[] = {-1,1,0,0};
    static int moveC[] = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();
        int result[] = new int[t];
        for (int j = 0; j < t; j++) {
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();

            Queue<Integer> pQueueR = new LinkedList<>();
            Queue<Integer> pQueueC = new LinkedList<>();

            int cnt = 0;
            int c = sc.nextInt();
            int r = sc.nextInt();
            int numWorm = sc.nextInt();

            int farmMat[][] = new int[r][c];

            for (int i=0; i<numWorm; i++) {
                int nowC = sc.nextInt();
                int nowR = sc.nextInt();
                farmMat[nowR][nowC] = 1;
                queueC.add(nowC);
                queueR.add(nowR);
            }

            while (!queueC.isEmpty()){
                int nowR = queueR.poll();
                int nowC = queueC.poll();

                if (farmMat[nowR][nowC] != 0) {
                    cnt++;
                    pQueueC.add(nowC);
                    pQueueR.add(nowR);
                }
                while (!pQueueC.isEmpty()) {
                    nowR = pQueueR.poll();
                    nowC = pQueueC.poll();

                    for (int i=0; i<4; i++) {
                        int nextR = nowR + moveR[i];
                        int nextC = nowC + moveC[i];

                        if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                        if (farmMat[nextR][nextC] == 0) continue;
                        farmMat[nextR][nextC] = 0;

                        pQueueC.add(nextC);
                        pQueueR.add(nextR);
                    }
                }


            }
            result[j] = cnt;
        }
        for (int i=0; i<t; i++) {
            System.out.println(result[i]);
        }
        sc.close();
    }
}
