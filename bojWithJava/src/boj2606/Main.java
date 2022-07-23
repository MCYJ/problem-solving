package boj2606;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        int visited[] = new int[vertex+1];

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for (int i=0; i<vertex+1; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i=0; i<edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            arrayList.get(u).add(v);
            arrayList.get(v).add(u);
        }
        while (!arrayList.get(1).isEmpty()) {
            visited[1] = 1;
            q.add(arrayList.get(1).get(0));
            arrayList.get(1).remove(0);
        }
        while (!q.isEmpty()) {
            int end = q.poll();
            if (visited[end] == 0) {
                visited[end] = 1;
                count++;
            }
            while (!arrayList.get(end).isEmpty()) {
                q.add(arrayList.get(end).get(0));
                arrayList.get(end).remove(0);
            }
        }

        System.out.println(count);


        sc.close();
    }
}
