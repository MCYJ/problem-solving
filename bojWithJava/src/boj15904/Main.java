package boj15904;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch[] = sc.nextLine().toCharArray();
        int i = 0;


        while (i < ch.length && ch[i] != 'U') i++;
        if (i == ch.length){
            System.out.println("I hate UCPC");
            return;
        }
        while (i < ch.length && ch[i] != 'C') i++;
        if (i == ch.length){
            System.out.println("I hate UCPC");
            return;
        }
        while (i < ch.length && ch[i] != 'P') i++;
        if (i == ch.length){
            System.out.println("I hate UCPC");
            return;
        }
        while (i < ch.length && ch[i] != 'C') i++;
        if (i == ch.length){
            System.out.println("I hate UCPC");
            return;
        }
        else System.out.println("I love UCPC");

        sc.close();
    }
}
