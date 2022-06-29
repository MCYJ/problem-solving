package boj1189_unsolved;

import java.util.*;

public class Main {
	static char map[][];
	static int k;
	static int count = 0;
	static int visited[][];
	static int R,C;
	
	static int[] nextR = {-1, 0, 1, 0};
	static int[] nextC = {0,-1, 0, 1};
	
	static void setArr(int r, int c, int moved) {
		
		
		if(r == 0 && c == C-1) {
			if(moved == k) {
				count++;
			}
			return;
		}
		else {
			if(r<0 || r>=R || c<0 || c>=C  || map[r][c] == 'T') {
				return;
			}
			else {
				for(int i=0;i<4;i++) {
					if(r+nextR[i]<0 || r+nextR[i]>=R || c+nextC[i]<0 || c+nextC[i]>=C) continue;
					if(visited[r+nextR[i]][c+nextC[i]] == 1 || map[r+nextR[i]][c+nextC[i]] == 'T') continue;
					visited[r][c] = 1;
					setArr(r+nextR[i], c+nextC[i], moved+1);
					visited[r][c] = 0;
				}
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		k = sc.nextInt();
		
		map = new char[R][C];
		visited = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		visited[R-1][0] = 1;
		setArr(R-1,0,1);
		System.out.println(count);
		sc.close();
	}
}
