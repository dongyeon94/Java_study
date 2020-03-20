package backjoon;

import java.util.Scanner;

public class P_14892 {
	static int[] one;
	static int[] two;
	static int[] three;
	static int[] four;
	
	
	public static int[] passing(int[] arr,int flag) {
		int[] answer =new int[arr.length];
//		1이 시계방향 -> 패싱
		if (flag==1) {
			for(int i=0;i<arr.length-1;i++) {
				answer[i] = arr[i+1];
			}
			answer[arr.length] = arr[0];
			return answer;
		}
		else {
			answer[0] = arr[0];
			for(int i=1;i<arr.length;i++) {
				answer[i] = arr[i+1];
			}			
			return answer;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}
