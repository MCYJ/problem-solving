package boj2212;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfSensor = sc.nextInt();
		int numOfCentral = sc.nextInt();
		
		int listOfSensor[] = new int[numOfSensor];
		int listOfTerm[] = new int[numOfSensor-1];
		
		for (int i = 0; i < listOfSensor.length; i++) {
			listOfSensor[i] = sc.nextInt();
		}
		
		Arrays.sort(listOfSensor);
		
		for (int i = 0; i < listOfSensor.length-1; i++) {
			listOfTerm[i] = listOfSensor[i+1] - listOfSensor[i];
		}
		
		Arrays.sort(listOfTerm);
		
		int minPath = 0;
		
		for (int i = 0; i < listOfTerm.length-numOfCentral+1; i++) {
			minPath += listOfTerm[i];
		}
		
		System.out.println(minPath);
		
		sc.close();
	}
}
