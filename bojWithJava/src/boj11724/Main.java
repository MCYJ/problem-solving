package boj11724;

import java.util.*;

public class Main {
    static int visited[];
    static int graph[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int vortex = sc.nextInt();
        int edge = sc.nextInt();

        visited = new int[vortex+1];
        graph = new int[vortex+1][vortex+1];

        for (int i=0; i<edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i=1; i<=vortex; i++) {
            if (visited[i] == 1)  continue;
            // 갯수 증가
            count++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int nowVortex = q.poll();
                if (visited[nowVortex] == 1) continue;
                visited[nowVortex] = 1;
                for (int j=i; j<=vortex; j++) {
                    if (graph[nowVortex][j] == 1) q.add(j);
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
