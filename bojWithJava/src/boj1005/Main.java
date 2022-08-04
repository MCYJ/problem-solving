package boj1005;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int result[] = new int[testCase];

        // testCase 별 진행ㅏ
        for (int i=0; i<testCase; i++) {
            int numOfBuilding = sc.nextInt();
            // 차수 저장용 배열
            int indegree[] = new int[numOfBuilding+1];
            // 건물 별 건설 시간 저장
            int listOfValue[] = new int[numOfBuilding+1];
            // 누적 시간 저장
            int listOfCumValue[] = new int[numOfBuilding+1];
            int matOfBuilding[][] = new int[numOfBuilding+1][numOfBuilding+1];
            int numOfTerm = sc.nextInt();

            for (int j=1; j<=numOfBuilding; j++) {
                listOfValue[j] = sc.nextInt();
            }
            for (int j=0; j<numOfTerm; j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                // 유향 그래프이므로 단방향으로만 값 반영
                matOfBuilding[u][v] = 1;
                // 진입차수 증가
                indegree[v]++;
            }
            Queue<Integer> q = new LinkedList<>();
            // q에 indegree 0인 vortex 저장
            for (int j=1; j<=numOfBuilding; j++) {
                if (indegree[j] == 0){
                    listOfCumValue[j] = listOfValue[j];
                    q.add(j);
                }
            }

            while (!q.isEmpty()) {
                int nowBuilding = q.poll();
                for (int j=1; j<=numOfBuilding; j++) {
                    if (matOfBuilding[nowBuilding][j] == 1) {
                        listOfCumValue[j] = Math.max(listOfCumValue[j], listOfValue[j] + listOfCumValue[nowBuilding]);
                        if (--indegree[j] == 0) q.add(j);
                    }
                }
            }

            //
            int targetBuilding = sc.nextInt();
            // result 배열에 값 저장
            result[i] = listOfCumValue[targetBuilding];
            /*
            for (int j=0; j<numOfBuilding; j++) {
                System.out.println(listOfCumValue[j]);
            }

            */
        }
        for (int i=0; i<testCase; i++) {
            System.out.println(result[i]);
        }
        sc.close();
    }
}
