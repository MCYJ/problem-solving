package boj7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int testCase;
	static int length;
	static int map[][];
	static int endR, endC;
	static int direction = Integer.MAX_VALUE;
	static int moved = 0;
	
	// 갈 수 있는 방향에 대한 좌표
	static int dr[] = {1,2,2,1,-1,-2,-2,-1};
	static int dc[] = {-2,-1,1,2,-2,-1,1,2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		int result[] = new int[testCase];
		// testcase만큼 반복
		for (int i = 0; i < testCase; i++) {
			length = sc.nextInt();
			
			map = new int[length][length];
			
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			
			moved = 0;
			
			endR = sc.nextInt();
			endC = sc.nextInt();
			
			Queue <Integer> queueR = new LinkedList<>();
			Queue <Integer> queueC = new LinkedList<>();
			
			map[startR][startC] = 1; 
			
			queueR.add(startR);
			queueC.add(startC);
			
			while(!queueR.isEmpty()) {
				int r = queueR.poll();
				int c = queueC.poll();
				
				if(r<0 || r>=length || c<0 || c>=length) continue;

				if(r == endR && c == endC) {
					result[i] = moved;
					break;
				}
				
				for (int j = 0; j < 8; j++) {
					int nextR = r+dr[j];
					int nextC = c+dc[j];
					
					if(nextR < 0 || nextR >= length || nextC < 0 || nextC >= length) continue;
					
					if(map[nextR][nextC] >= 1) continue;
					map[nextR][nextC] = map[r][c] + 1;
					queueR.add(nextR);
					queueC.add(nextC);
				}
				moved++;
				
				
			}
			// 모든 순회 후, endR, endC의 map값 저장
			result[i] = map[endR][endC]-1;
		}
		// testcase별 출력
		for (int i = 0; i < testCase; i++) {
			System.out.println(result[i]);
		}
		
		sc.close();
	}
}
