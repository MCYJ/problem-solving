package boj1106;

import java.util.*;


public class Main {
	static int customer;
	static int listOfTotalPrice[] = new int[1100];
	
	static int numberOfCustomer[];
	static int listOfPrice[];
	
	static int numberOfCity;
	
	static void setList(int idx, int price) {
		// custotmer 수 초과하면 return
		if(idx >= 1100) return;
		
		// 이미 저장된 값보다 크면 return
		// -> 더이상 연산을 진행할 필요 없음, 앞에  있던 값 기준으로 더하는게 모조건 저렴함
		if(listOfTotalPrice[idx] <= price) return;
		
		// 금액기준으로 비교해야됨!!!
		// 수정요망
		if(idx >= 1100) return;
		else {
			listOfTotalPrice[idx] = Math.min(listOfTotalPrice[idx], price);
			// 입력받은 리스트 순회
			for (int i = 0; i < numberOfCity; i++) {
				setList(idx+numberOfCustomer[i], price+listOfPrice[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Arrays.fill(listOfTotalPrice, Integer.MAX_VALUE);
		Scanner sc = new Scanner(System.in);
		
		customer = sc.nextInt();
		numberOfCity = sc.nextInt();
		
		numberOfCustomer = new int[numberOfCity];
		listOfPrice = new int[numberOfCity];
		
		for (int i = 0; i < numberOfCity; i++) {
			listOfPrice[i] = sc.nextInt();
			numberOfCustomer[i] = sc.nextInt();
		}
		
		setList(0, 0);
		
		int smallestPrice = listOfTotalPrice[customer];
		// listOfTotalPrice[customer]에서 출발해서 마지막index까지 가면서 가장 작은 값 저장
		// -> 더 적은 금액으로 더 많은 사람 유치할 수 있기 때문에
		for (int i = customer; i < 1100; i++) {
			smallestPrice = Math.min(smallestPrice, listOfTotalPrice[i]);
		}
		
		
		
		System.out.println(smallestPrice);
		
		sc.close();
	}
}
