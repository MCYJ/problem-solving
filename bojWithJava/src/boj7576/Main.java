package boj7576;

import java.util.*;

public class Main {
    static int r,c;
    static int arr[][];
    // 상하좌우 방향 전환용 행렬 선언
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    // 순회 횟수를 저장하는 round 변수
    static int round = 0;
    static int numOfZero = 0;
    static int madeOfTomato = 0;

    static Queue<Integer> qr = new LinkedList<>();
    static Queue<Integer> qc = new LinkedList<>();

    static void dfs(int nowR, int nowC){
        if (arr[nowR][nowC] == 0) {
            arr[nowR][nowC] = 1;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        r = sc.nextInt();

        // rxc 행렬 생성
        arr = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int num = sc.nextInt();
                arr[i][j] = num;
                // num이 1일 경우 queue에 저장
                if (num == 1) {
                    qr.add(i);
                    qc.add(j);
                }
                else if(num == 0) numOfZero++;
            }
        }
        // 순회 횟수 측정위한 도구 : poll() 통해 -2 반환되는 경우 round++
        qr.add(-2);
        qc.add(-2);

        while (!qr.isEmpty()) {
            int nowR = qr.poll();
            int nowC = qc.poll();
        //    System.out.println(nowR+" "+nowC);
            if (nowR == -2) {
                if(qr.isEmpty()) {
                    if(numOfZero == madeOfTomato) System.out.println(round);
                    else System.out.println(-1);
                    return;
                }
                round++;
                qr.add(-2);
                qc.add(-2);
            }
            else {
                // 상하좌우 순회하며 dfs로 보냄
                for (int i=0;i<4;i++) {
                    int nextR = nowR + dr[i];
                    int nextC = nowC + dc[i];

                    // 행렬을 벗어나는 경우에는 continue
                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                    // 1이거나 -1인 경우에는 continue
                    if (arr[nextR][nextC] == 1 || arr[nextR][nextC] == -1) continue;
                    arr[nextR][nextC] = 1;
                    madeOfTomato++;
                    qr.add(nextR);
                    qc.add(nextC);
                }
            }
        }

        if(numOfZero == madeOfTomato) System.out.println(round);
        else System.out.println(-1);
        sc.close();
    }
}
