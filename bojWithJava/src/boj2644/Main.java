package boj2644;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        int numOfPerson = sc.nextInt();
        int sPerson = sc.nextInt();
        int ePerson = sc.nextInt();
        int visited[] = new int[numOfPerson+1];
        int edge = sc.nextInt();
        int count = 0;
        int isConnected = 0;

        int personMat[][] = new int[numOfPerson+1][numOfPerson+1];

        for (int i=0; i<edge; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            personMat[start][end] = 1;
            personMat[end][start] = 1;
        }

        q.add(sPerson);
        q.add(-1);

        while (!q.isEmpty()) {
            int nowPerson = q.poll();

            if (nowPerson == -1) {
                if (q.isEmpty()) {
                    count++;
                    if (isConnected == 0) System.out.println(-1);
                    else System.out.println(count);
                    return;
                }
                count++;
                q.add(-1);
                continue;
            }

            if (nowPerson == ePerson){
                isConnected = 1;
                break;
            }


            // 이미 방문한 경우
            if (visited[nowPerson] == 1) continue;

            visited[nowPerson] = 1;
            for (int i=1; i<=numOfPerson; i++) {
                if (personMat[nowPerson][i] == 1) q.add(i);
            }

        }

    //    if (isConnected == 0) System.out.println(-1);
    //    else System.out.println(count);


        sc.close();
    }
}
