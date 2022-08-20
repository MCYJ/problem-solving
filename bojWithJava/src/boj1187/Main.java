package boj1187;

import java.util.*;

public class Main {
    // 목표값
    static int targetNum;
    static int n;
    static int arr[];
    // targetNum이 되는 부분 수열의 갯수
    static int numOfSubSequence = 0;

    static void getSeqSequence(int index, int count){


        if (index >= n-1){
            if (count == targetNum) {
                numOfSubSequence++;
            }
            return;
        }
        getSeqSequence(index+1, count);
        getSeqSequence(index+1, count + arr[index+1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        targetNum = sc.nextInt();

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }


        getSeqSequence(-1, 0);
        if(targetNum == 0) System.out.println(numOfSubSequence-1);
        else System.out.println(numOfSubSequence);

        sc.close();
    }
}
