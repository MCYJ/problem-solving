package boj1358;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int p = sc.nextInt();

        int count = 0;

        int listX[] = new int[p];
        int listY[] = new int[p];

        for (int i=0; i<p; i++) {
            listX[i] = sc.nextInt();
            listY[i] = sc.nextInt();
        }

        for (int i=0; i<p; i++) {
            int nowX = listX[i];
            int nowY = listY[i];

            if (nowY < y) continue;
            if (nowY > y + h) continue;

            if (nowX < x) {
                if (Math.pow(x - nowX, 2) + Math.pow(nowY - y - h / 2, 2) <= Math.pow(h, 2) / 4) count++;
            }
            else if (nowX <= x + w) count++;
            else {
                    if (Math.pow(nowX-x-w, 2)+Math.pow(nowY-y-h/2, 2) <= Math.pow(h, 2)/4 ) count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
