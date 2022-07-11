package boj7569;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int date = 0;

        int c = sc.nextInt();
        int r = sc.nextInt();
        int h = sc.nextInt();

        int numOfTomato = 0;

        int dC[] = {-1,1,0,0,0,0};
        int dR[] = {0,0,-1,1,0,0};
        int dH[] = {0,0,0,0,-1,1};

        Queue<Integer> qC = new LinkedList<>();
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qH = new LinkedList<>();

        int arr[][][] = new int[h][r][c];

        for (int i=0; i<h; i++) {
            for (int j=0; j<r; j++) {
                for (int k=0; k<c; k++) {
                    int num = sc.nextInt();
                    arr[i][j][k] = num;
                    if (num == 1) {
                        qC.add(k);
                        qR.add(j);
                        qH.add(i);
                    } else if (num == 0) {
                        numOfTomato++;
                    }
                }
            }
        }

        qC.add(-2);
        qR.add(-2);
        qH.add(-2);

        while (!qC.isEmpty()) {
            int nowC = qC.poll();
            int nowR = qR.poll();
            int nowH = qH.poll();

            if (nowC == -2) {
                date++;
                if (qC.isEmpty()) break;
                qC.add(-2);
                qR.add(-2);
                qH.add(-2);
            }

            for (int i=0; i<6; i++) {
                int nextC = nowC + dC[i];
                int nextR = nowR + dR[i];
                int nextH = nowH + dH[i];

                // 박스를 벗어나는 조건 확인
                if (nextC < 0 || nextC >= c || nextR < 0 || nextR >= r || nextH < 0 || nextH >= h) continue;
                // 박스에 이미 1이 존재하는지 확인
                if (arr[nextH][nextR][nextC] == 1 || arr[nextH][nextR][nextC] == -1) continue;
                // 0을 만날 경우 queue에 add()
                arr[nextH][nextR][nextC] = 1;
                numOfTomato--;
                qC.add(nextC);
                qR.add(nextR);
                qH.add(nextH);
            }
        }
        if (numOfTomato == 0) System.out.println(date-1);
        else System.out.println(-1);

        sc.close();
    }
}
