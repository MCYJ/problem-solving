package boj12852;

import java.util.*;

public class Main {
    static int arr[];
    static int union[];
    static int num;
    static int answerList[];
    static void dfs(int nowNum, int count) {
        if (nowNum < 1) return;
        if (nowNum == 1) {
            arr[1] = Math.min(arr[1], count);
            return;
        }
        if (arr[nowNum] < count) return;
        arr[nowNum] = count;

        // 2로 나눠지는 경우
        if (nowNum % 2 == 0) {
            dfs(nowNum/2, count+1);
        }
        if (nowNum % 3 == 0) {
            dfs(nowNum/3, count+1);
        }
        dfs(nowNum-1, count+1);
    }

    static void findNum (int nowNum, int count) {
        if (answerList[0] != -1) return;
        if (nowNum > num) return;
        if (arr[nowNum] == count) {
            answerList[count] = nowNum;
        } else {
            return;
        }


        findNum(nowNum*2,count-1);
        findNum(nowNum*3, count-1);
        findNum(nowNum+1, count-1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();

        arr = new int[num+1];
        union = new int[num+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        Arrays.fill(union, -1);

        arr[num] = 0;

        dfs(num, 0);

        System.out.println(arr[1]);

        answerList = new int[arr[1]+1];
        Arrays.fill(answerList, -1);

        findNum(1,arr[1]);

        for (int i=0; i<answerList.length; i++) {
            System.out.print(answerList[i]+" ");
        }

        sc.close();
    }
}
