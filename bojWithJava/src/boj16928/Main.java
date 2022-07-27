package boj16928;

import java.util.*;

public class Main {
    static int path[] = new int[101];
    static int dMove[] = {1,2,3,4,5,6};

    static int listOfLadder[][];
    static int listOfSnake[][];

    static void dfs(int position, int cost) {
        if (cost >= 99) return;
        // 100보다 큰 지점 도달 시 종료
        if (position >= 101) return;

        for (int i=0; i<listOfLadder.length; i++) {
            if (position == listOfLadder[i][0]) {
                path[listOfLadder[i][1]] = Math.min(path[listOfLadder[i][1]], cost);
                position = listOfLadder[i][1];
                break;
            }
        }
        for (int i=0; i<listOfSnake.length; i++) {
            if (position == listOfSnake[i][0]) {
                path[listOfSnake[i][1]] = Math.min(path[listOfSnake[i][1]], cost);
                position = listOfSnake[i][1];
                break;
            }
        }

        if (path[position] < cost) return;
        else path[position] = cost;


        for (int i=0; i<dMove.length; i++) {
            dfs(position+dMove[i], cost+1);
        }
    }
    
    public static void main(String[] args) {
        Arrays.fill(path, Integer.MAX_VALUE);
        
        Scanner sc = new Scanner(System.in);

        int numOfLadder = sc.nextInt();
        int numOfSnake = sc.nextInt();

        listOfLadder = new int[numOfLadder][2];
        listOfSnake = new int[numOfSnake][2];

        // 사다리정보 저장
        for (int i = 0; i < numOfLadder; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            listOfLadder[i][0] = start;
            listOfLadder[i][1] = end;
        }

        // 뱀정보 저장
        for (int i = 0; i < numOfSnake; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            listOfSnake[i][0] = start;
            listOfSnake[i][1] = end;
        }
        for (int i=1; i<=6; i++) {
            path[i] = 1;
        }
        dfs(1,0);

        System.out.println(path[100]);

        sc.close();
    }
}
