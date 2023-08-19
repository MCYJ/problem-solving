package boj1011_unsolved;

import java.util.*;

public class Main {
    static int delta[] = {-1,0,1};
    static int distance;
    static int cnt = 0;

    static void bfs(int k, int distance, int cnt){
        if (k<0) return;
        // 마지막 k는 1이 되어야 하므로
        if (distance-k < 0) return;
        else if(distance-k == 0){
            if (k != 1) return;
            else {
                System.out.println(cnt);
                return;
            }
        }
        else {
            for (int i=0; i<3; i++) {
                if (k+delta[i] < 0 || distance-k < 0) continue;
                bfs(k+delta[i], distance-(k+delta[i]), cnt+1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // int t = sc.nextInt();
        // 결과 저장
        // int result[] = new int[t];
        int result;
        int x = sc.nextInt();
        int y = sc.nextInt();
        distance = y-x;

        bfs(1, distance, 1);

        sc.close();
    }
}
