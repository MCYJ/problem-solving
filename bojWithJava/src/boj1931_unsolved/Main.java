package boj1931_unsolved;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int listOfMeeting[] = new int[2^31];
        Arrays.fill(listOfMeeting, -1);
        int biggestNum = 0;
        int smallestNum = Integer.MAX_VALUE;
        int numOfMeeting = 0;


        for (int i=0;i<n;i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            if (biggestNum < end) biggestNum = end;
            if (smallestNum > end) smallestNum = end;

            listOfMeeting[end] = Math.max(listOfMeeting[end], start);
        }
        int flagNum = 0;
        // 가장 작은 end 수가 가장 큰 end 수를 넘어갈 때
        while(smallestNum <= biggestNum){
            if(listOfMeeting[smallestNum] != -1){
                // 시작하자마자 끝나는 meeting
                if (smallestNum == listOfMeeting[smallestNum]) {
                    flagNum = smallestNum + 1;
                    numOfMeeting++;
                }
                else if(flagNum < listOfMeeting[smallestNum]){

                    flagNum = smallestNum;
                    numOfMeeting++;
                }
            }

            smallestNum++;

        }

        System.out.println(numOfMeeting);

        sc.close();
    }
}