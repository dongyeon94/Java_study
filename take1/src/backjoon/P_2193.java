package backjoon;

import java.util.ArrayList;
import java.util.Scanner;

/*
public class Main {
	public static void main(String[] args) {
  
	}
}
*/
public class P_2193 {

	
	public long fibo(long n) {
		if (n<=0) {
			return 1;
		}
		if (n==1) {
			return 1;
		}
		else {
			long[] arr1 = new long[3];
			arr1[0]=1;
			arr1[1]=1;
			arr1[2]=2;
			for(int i=0; i<n-2;i++) {
				arr1[2] = arr1[0]+arr1[1];
				arr1[0] = arr1[1];
				arr1[1] = arr1[2];
			}
			return arr1[2];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P_2193 sol = new P_2193();
		Scanner scan = new Scanner(System.in);
		int kk = scan.nextInt();
		System.out.println(sol.fibo(kk));
	}

}
