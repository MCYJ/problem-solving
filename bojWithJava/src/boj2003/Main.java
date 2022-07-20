package boj2003;

// 2003 : 수들의 합
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = 0;
        int tot = 0;

        int count = 0;


        while (start < n && end < n) {
            while (start < n && tot <= m) {
                tot += arr[start];
                if (tot == m) count++;
                start++;
            }

            while (end < n && tot > m) {
                tot -= arr[end];
                if (tot == m) count++;
                end++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
