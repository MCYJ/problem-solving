package boj14500;

import java.util.*;

public class Main {
    static int arr[][];
    static int visited[][];
    static int tot = 0;
    static int r, c;
    static int indexForR, indexForC;
    static void dfs(int nowR, int nowC, int count, int sum){
        // nowR / now C 검증 : 범위안의 숫자인지
        if (nowR < 0 || nowR >= r || nowC < 0 || nowC >= c) return;
        if (visited[nowR][nowC] == 1) return;
        // sum에 가중치 더함
        sum += arr[nowR][nowC];

        // count == 4 인경우
        if (count == 4) {
            // tot와 값 비교해서 큰 값 저장해야 함
            tot = Math.max(tot, sum);

            return;
        }

        // count == 2 인경우, 경로 저장
        if (count == 2) {
            indexForR = nowR;
            indexForC = nowC;
        }
        visited[nowR][nowC] = 1;
        // count == 3 인경우, 2번째로 갔다온 경로 기준으로'도' 경로 진행해볼것 / [ㅗ] 모양때문에
        if (count == 3) {
            dfs(indexForR+1, indexForC, count+1, sum);
            dfs(indexForR-1, indexForC, count+1, sum);
            dfs(indexForR, indexForC+1, count+1, sum);
            dfs(indexForR, indexForC-1, count+1, sum);
        }
        // 오른쪽 / 아래 두가지 케이스로 dfs 재귀
        dfs(nowR+1, nowC, count+1, sum);
        dfs(nowR-1, nowC, count+1, sum);
        dfs(nowR, nowC+1, count+1, sum);
        dfs(nowR, nowC-1, count+1, sum);
        visited[nowR][nowC] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        // rXc 배열 생성
        arr = new int[r][c];
        visited = new int[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                dfs(i, j, 1, 0);
            }
        }

        System.out.println(tot);

        sc.close();
    }
}
