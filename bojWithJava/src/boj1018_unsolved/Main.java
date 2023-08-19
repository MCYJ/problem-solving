package boj1018_unsolved;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		int diff = 0;

		String str[] = new String[r];

		for (int i=0; i<r; i++) {
			str[i] = sc.next();
		}

		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				// i + j 가 짝수인 경우, 'W'가 되어야 한다는 가정, 이와 다를 시 COUNT
				if ((i + j)%2 == 0 && str[i].charAt(j) == 'B') {
					diff++;
				}
				if ((i + j)%2 == 1 && str[i].charAt(j) == 'W') {
					diff++;
				}
			}
		}

		if (r * c - diff > diff) {
			System.out.println(diff);
		} else {
			System.out.println(r * c - diff);
		}
		
		sc.close();
	}
}
