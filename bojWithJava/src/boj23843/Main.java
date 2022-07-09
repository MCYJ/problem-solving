package boj23843;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전자기기
        int n = sc.nextInt();
        // 콘센트
        int m = sc.nextInt();

        int appliance[] = new int[n];
        int concent[] = new int[m];

        for (int i=0; i<n; i++) {
            appliance[i] = sc.nextInt();

        }
        Arrays.sort(appliance);

        for (int i=0; i<n; i++) {
            Arrays.sort(concent);
            concent[0] += appliance[n-i-1];
        }
        Arrays.sort(concent);

        System.out.println(concent[m-1]);
        sc.close();
    }
}
