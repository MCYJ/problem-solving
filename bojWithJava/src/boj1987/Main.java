package boj1987;

import java.util.*;

public class Main {
    // 방문기록 관리
    static int visited[] = new int[26];
    static int count = 0;
    static int mat[][];
    static int r,c;
    static int dR[] = {0,0,-1,1};
    static int dC[] = {-1,1,0,0};

    static void dfs(int nowR, int nowC, int nowCount) {
        // index가 범위밖일때 return
        if (nowR < 0 || nowR >= r || nowC < 0 || nowC >= c) return;
        // 방문이력 있을때 return
        // count 기존값과 비교하여 큰값으로 update
        if (visited[mat[nowR][nowC]] == 1){
            count = (count > nowCount) ? count : nowCount;
            return;
        }

        visited[mat[nowR][nowC]] = 1;
        for (int i=0; i<4; i++) {
            dfs(nowR+dR[i], nowC+dC[i], nowCount+1);
        }
        visited[mat[nowR][nowC]] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();

        mat = new int[r][c];

        for (int i=0; i<r; i++) {
            char listOfLine[] = sc.next().toCharArray();
            for (int j=0; j<listOfLine.length; j++) {
                mat[i][j] = listOfLine[j]-'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(count);

        sc.close();
    }
}
