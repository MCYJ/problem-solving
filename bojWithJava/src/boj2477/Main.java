package boj2477;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int weight = sc.nextInt();

        int visited[] = new int[5];
        int mat[][] = new int[6][2];


        for (int i=0; i<6; i++) {
            int direction = sc.nextInt();
            int length = sc.nextInt();

            visited[direction]++;
            mat[i][0] = direction;
            mat[i][1] = length;
        }
        int i=0;
        while(visited[mat[i][0]] != 1){
            i++;
        }
        if (i == 0) {
            if (visited[mat[1][0]] == 2) {
                System.out.println(weight * (mat[0][1] * mat[5][1] - mat[2][1] * mat[3][1]));
            } else {
                System.out.println(weight * (mat[0][1] * mat[1][1] - mat[3][1] * mat[4][1]));
            }

        } else {
            System.out.println(weight* (mat[i][1] * mat[i+1][1] - mat[(6+i-2)%6][1] * mat[(6+i+3)%6][1]));
        }


        sc.close();
    }
}
