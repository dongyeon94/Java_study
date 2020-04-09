package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
// 2104   -> 시간초과 메모리 초과 -> 리스트 슬라이싱이 필요함 지금도 너무 크다
	public int sum(ArrayList<Integer> arr) {
		int val=0;
		for(int i=0;i<arr.size();i++) {
			val += arr.get(i);
		}
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main sol = new Main();
		long answer =0;
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
        
		for(int i=0;i<len;i++) {
			arr.add(sc.nextInt());
		}
		

		for(int j=len;j>=0;j--) {
			for(int i=0;i<j;i++) {
				ArrayList<Integer> li2 =new ArrayList<Integer>( arr.subList(i, j));
				int sum = sol.sum(li2);				
				int min = Collections.min(li2);
				
//				for(int kk=0;kk<li2.size();kk++) {
//					System.out.print(li2.get(kk)+"  ");
//				}
//				System.out.println(sum+"//"+min+"///"+sum*min);
				
				if (answer < sum*min) answer =sum*min;
			}
				
		}
		
		
		System.out.println(answer);
		
	}

}
