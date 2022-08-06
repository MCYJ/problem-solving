package boj2667;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int dR[] = {0, 0, -1, 1};
        int dC[] = {-1, 1, 0, 0};

        int length = sc.nextInt();

        int mat[][] = new int[length][length];
        int listOfCount[] = new int[length*length];

        for (int i=0; i<length; i++) {
            char line[] = sc.next().toCharArray();
            for (int j=0; j<length; j++) {
                mat[i][j] = line[j]-'0';
            }
        }
        int m = 0;
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (mat[i][j] == 0) continue;
                int count = 0;

                Queue<Integer> qR = new LinkedList<>();
                Queue<Integer> qC = new LinkedList<>();


                qR.add(i);
                qC.add(j);

                while (!qR.isEmpty()) {
                    int nowR = qR.poll();
                    int nowC = qC.poll();

                    if (mat[nowR][nowC] == 0) continue;
                    mat[nowR][nowC] = 0;
                    count++;

                    for (int k=0; k<4; k++) {
                        int nextR = nowR + dR[k];
                        int nextC = nowC + dC[k];

                        if (nextR < 0 || nextR >= length || nextC < 0 || nextC >= length) continue;
                        if (mat[nextR][nextC] == 0) continue;

                        qR.add(nextR);
                        qC.add(nextC);
                    }
                }

                listOfCount[m++] = count;
            }
        }
        Arrays.sort(listOfCount);
        int i = 0;
        while (i<listOfCount.length && listOfCount[i] == 0) {
            i++;
        }
        System.out.println(listOfCount.length - i);
        while (i < listOfCount.length) {
            System.out.println(listOfCount[i]);
            i++;
        }
        sc.close();
    }
}
