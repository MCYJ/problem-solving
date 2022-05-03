package boj1259;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		DynamicArray strList = new DynamicArray();
		
		// 입력이 0이 아닌 경우 지속적으로 입력
		while(!str.equals("0")) {
			strList.append(str);
			str = sc.next();
		}
		for(int i=0;i<strList.strList.length;i++) {
			System.out.println(checkDrom(strList.strList[i]));
		}
		
		sc.close();
	}
	
	// function name : checkDrom
	// parameter : String
	// return : String ("yes" or "no")
	static String checkDrom(String str) {
		for(int i=0;i<(str.length()/2);i++) {
			if (str.charAt(i) != (str.charAt(str.length()-i-1))) return "no";
		}
		return "yes";
	}
	

}

class DynamicArray {
	int capacity;
	String strList[] = new String[0];
	
	
	public DynamicArray() {
		this.capacity = 0;
	}
	
	void append(String str) {
		String[] tempList = new String[this.strList.length+1];
		for(int i=0;i<this.strList.length;i++) {
			tempList[i] = strList[i];
		}
		tempList[this.strList.length] = str;
		this.strList = tempList;
	}
	
	void print() {
		for(int i=0;i<strList.length;i++) {
			System.out.println(strList[i]);
		}
	}
	
}
