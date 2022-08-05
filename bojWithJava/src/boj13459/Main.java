package boj13459;

import java.util.*;

public class Main {
    static char mat[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int rBlue = 0, cBlue = 0;
        int rRed = 0, cRed = 0;

        mat = new char[r][c];

        for (int i=0; i<r; i++) {
            char line[] = sc.next().toCharArray();
            for (int j=0; j<c; j++) {
                if (line[j] == 'B') {
                    rBlue = i;
                    cBlue = j;
                    mat[i][j] = '.';
                } else if (line[j] == 'R') {
                    rRed = i;
                    cRed = j;
                    mat[i][j] = '.';
                } else {
                    mat[i][j] = line[j];
                }
            }
        }

        // 4^10 번의 경우의 수 모두 순회하며 계산
        for (int i=0; i<1048576; i++) {
            int temp = i;
            // blue / red 구슬 위치 initialize
            int nowRBlue = rBlue;
            int nowCBlue = cBlue;
            int nowRRed = rRed;
            int nowCRed = cRed;


            int blueOut = 0;
            int redOut = 0;

            // 10번의 연산진행
            for (int j=0; j<10; j++) {
                // 방향 설정
                int direction = temp%4;
                temp /= 4;

                // direction에 따라 blue와 red위치 변경
                if (direction == 0) {
                    if (nowRBlue < nowRRed) {
                        while (mat[nowRBlue-1][nowCBlue] != '#') {
                            nowRBlue--;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;

                            }
                        }
                        while (mat[nowRRed-1][nowCRed] != '#' && (!(nowRRed-1 == nowRBlue && nowCRed == nowCBlue) || blueOut == 1)) {
                            nowRRed--;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;
                                break;
                            }
                        }
                    } else {
                        while (mat[nowRRed-1][nowCRed] != '#') {
                            nowRRed--;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;

                            }
                        }
                        while (mat[nowRBlue-1][nowCBlue] != '#' && (!(nowRRed == nowRBlue-1 && nowCRed == nowCBlue) || redOut == 1)) {
                            nowRBlue--;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;
                                break;
                            }
                        }
                    }
                } else if (direction == 1) {
                    if (nowCBlue > nowCRed) {
                        while (mat[nowRBlue][nowCBlue+1] != '#') {
                            nowCBlue++;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;

                            }
                        }
                        while (mat[nowRRed][nowCRed+1] != '#' && (!(nowRRed == nowRBlue && nowCRed+1 == nowCBlue) || blueOut == 1)) {
                            nowCRed++;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;
                                break;
                            }
                        }
                    } else {
                        while (mat[nowRRed][nowCRed+1] != '#') {
                            nowCRed++;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;

                            }
                        }
                        while (mat[nowRBlue][nowCBlue+1] != '#' && (!(nowRRed == nowRBlue && nowCRed == nowCBlue+1) || redOut == 1)) {
                            nowCBlue++;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;
                                break;
                            }
                        }
                    }
                } else if (direction == 2) {
                    if (nowRBlue > nowRRed) {
                        while (mat[nowRBlue+1][nowCBlue] != '#') {
                            nowRBlue++;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;

                            }
                        }
                        while (mat[nowRRed+1][nowCRed] != '#' && (!(nowRRed+1 == nowRBlue && nowCRed == nowCBlue) || blueOut == 1)) {
                            nowRRed++;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;
                                break;
                            }
                        }
                    } else {
                        while (mat[nowRRed+1][nowCRed] != '#') {
                            nowRRed++;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;

                            }
                        }
                        while (mat[nowRBlue+1][nowCBlue] != '#' && (!(nowRRed == nowRBlue+1 && nowCRed == nowCBlue) || redOut == 1)) {
                            nowRBlue++;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;
                                break;
                            }
                        }
                    }
                } else if (direction == 3) {
                    if (nowCBlue < nowCRed) {
                        while (mat[nowRBlue][nowCBlue-1] != '#') {
                            nowCBlue--;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;

                            }
                        }
                        while (mat[nowRRed][nowCRed-1] != '#' && (!(nowRRed == nowRBlue && nowCRed-1 == nowCBlue) || blueOut == 1)) {
                            nowCRed--;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;
                                break;
                            }
                        }
                    } else {
                        while (mat[nowRRed][nowCRed-1] != '#') {
                            nowCRed--;
                            if (mat[nowRRed][nowCRed] == 'O') {
                                redOut = 1;

                            }
                        }
                        if (nowCBlue == 0) {
                            System.out.println("!");
                        }
                        while (mat[nowRBlue][nowCBlue-1] != '#' && (!(nowRRed == nowRBlue && nowCRed == nowCBlue-1) || redOut == 1)) {
                            nowCBlue--;
                            if (mat[nowRBlue][nowCBlue] == 'O'){
                                blueOut = 1;
                                break;
                            }
                        }
                    }
                }
                // O에 blue가 빠져나가는 경우
                // break로 이번 순회를 종료
                if (blueOut == 1 || (redOut == 1 && blueOut == 1)) break;
                // O에 red가 빠져나가는 경우
                // 1 출력하고 종료
                if (redOut == 1){
                    System.out.println(1);
                    return;
                }

            }
        }

        // 4^10의 순회에서 red가 빠져나가지 못한 경우이므로 0출력
        System.out.println(0);

        sc.close();
    }
}
