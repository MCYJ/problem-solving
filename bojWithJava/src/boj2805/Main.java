package boj2805;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나무갯수
        int n = sc.nextInt();
        // 필요한 나무의 길이
        int m = sc.nextInt();
        // 확보된 나무의 길이
        int tot = 0;
        // 동일한 높이의 나무의 갯수
        // int sameTree = 1;
        // 나무길이의 목록
        int treeList[] = new int[n];

        for (int i = 0; i<n;i++) {
            treeList[i] = sc.nextInt();
        }
        // 나무를 높이순으로 정렬
        Arrays.sort(treeList);

        int i = n-1;
        int length = 0;
        int level = treeList[i];
        int same = 1;
        while (length < m) {
            while (i>0 && level <= treeList[i-1]) {
                same++;
                i--;
            }

            length += same;

            level--;
        }

        System.out.println(level);

        sc.close();
    }
}
