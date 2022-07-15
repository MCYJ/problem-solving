package boj2252;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정점의 숫자 입력
        int n = sc.nextInt();

        int indegree[] = new int[n];
        // 간선의 숫자 입력
        int m = sc.nextInt();

        // arraylist 생성
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        // indegree+간선 초기화
        for (int i=0; i<m; i++) {
            // 학생번호는 1번부터 시작하는 것 감안하여 index-1 처리
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;

            // 각각의 start에 종점 요소 추가시킴
            adj.get(start).add(end);

            // 인덱스 end의 indegree 증가시킴
            indegree[end]++;
        }

        // 큐 선언
        Queue<Integer> q = new LinkedList<>();

        // indegree == 0 인 index들 queue에 저장
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // queue안의 값이 없어질 때까지 반복
        while (!q.isEmpty()) {
            int start = q.poll();
            System.out.print(start+1+" ");
            for (int i=0; i<adj.get(start).size(); i++) {
                int end = adj.get(start).get(i);
                indegree[end]--;
                if (indegree[end] == 0) q.add(end);
            }
        }
        System.out.println();
        sc.close();
    }

}
