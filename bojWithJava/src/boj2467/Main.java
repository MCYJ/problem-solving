package boj2467;

import java.util.*;

public class Main {
    static int smallLiquid;
    static int largestLiquid;
    static int tolOfLiquid = Integer.MAX_VALUE;
    // 용액을 저장하기 위한 배열 생성
    static int liquidList[];

    static int biSearch(int start, int end, int key, int index) {
        int mid;
        while (start < end) {
            mid = (start+end)/2;
            if (mid == start) break;
            if (liquidList[mid] == key) {
                return mid;
            }
            else if (liquidList[mid] > key){
                end = mid;
            }
            else start = mid;
        }
        if (Math.abs(liquidList[end] - key) > Math.abs(liquidList[start] - key)) {
            return start;
        }
        else return end;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 전체 용액의 수
        int n = sc.nextInt();
        if (n == 2) {
            int firstNum = sc.nextInt();
            int secondNum = sc.nextInt();
            System.out.println(firstNum+" "+secondNum);
            return;
        }

        liquidList = new int[n];

        // 용액 입력
        for (int i=0; i<n; i++) {
            liquidList[i] = sc.nextInt();
        }

        // for문을 통해 해당 용액을 기준으로 뒤의 용액들간 이진탐색을 진행함
        // n-2까지만 순회함 -> 마지막에 용액 1개는 남아있어야 탐색가능
        for (int i=0; i<n-1; i++) {
            int key = liquidList[i];
            int start = i+1;
            int end = n-1;
            int indexForKey = biSearch(start, end, -key, i);
            if (tolOfLiquid > Math.abs(key + liquidList[indexForKey])){
                smallLiquid = key;
                largestLiquid = liquidList[indexForKey];
                tolOfLiquid = Math.abs(key + liquidList[indexForKey]);
            }
        }

        System.out.println(smallLiquid+" "+largestLiquid);

        sc.close();
    }
}
