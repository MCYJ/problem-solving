package boj2609;

import java.util.*;

public class Main {
    static int gcd(int a, int b){
        while(a%b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(b>a){
            int temp = b;
            b = a;
            a = temp;
        }
        int result = gcd(a, b);
        System.out.println(result);
        System.out.println(a*b/result);
    }
}
