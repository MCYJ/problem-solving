package boj1541;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char str[] = sc.next().toCharArray();
        int tot = 0;
        int num = 0;
        int isMinus = 0;

        int i = 0;

        while (i < str.length && str[i] != '+' && str[i] != '-') {
            tot = tot*10 + str[i] - 48;
            i++;
        }

        while (i < str.length) {
            if (str[i] == '+' && isMinus == 0) {
                i++;
                while (i < str.length && str[i] != '+' && str[i] != '-') {
                    num = num*10 + str[i] - 48;
                    i++;
                }
                tot += num;
                num = 0;
            } else if (str[i] == '-' || isMinus == 1) {
                isMinus = 1;
                i++;
                while (i < str.length && str[i] != '+' && str[i] != '-') {
                    num = num * 10 + str[i] - 48;
                    i++;
                }
                tot -= num;
                num = 0;
            }
        }

        System.out.println(tot);

        sc.close();
    }
}
