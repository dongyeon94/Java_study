package backjoon;

import java.awt.Window.Type;
import java.util.Scanner;

public class P_14891 {

	static String[][] tob= new String[4][8];
	
	
	public static String[][] passing(int index, int flag) {
		String[] answer =tob[index];
//		1이 시계방향 -> 패싱
		if (flag==1) {
			for(int i=0;i<tob.length-1;i++) {
				tob[index][i] = answer[i+1];
			}
			tob[index][tob.length] = answer[0];
			return tob;
		}
		else {
			tob[index][0] = answer[0];
			for(int i=1;i<tob.length;i++) {
				tob[index][i] = answer[i+1];
			}			
			return tob;
		}
	}
	
	public static void turn(int index,int flag,int frist) {
		if (index <3 && frist<index) {
			String front = tob[index][2];
			index++;
			String back  = tob[index][6];
			if (front!= back) flag=-flag;
			passing(index, flag);
		}
		else if(index>0 && frist>index) {
			String front = tob[index][6];
			index--;
			String back  = tob[index][2];
			if (front!= back) flag=-flag;
			passing(index, flag);
			
		}
		
	}
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P_14891 m = new P_14891();
		int answer = 0;	
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		String d = sc.next();
		for(int i=0;i<a.length();i++) 
		{
			tob[0][i]= String.valueOf( a.charAt(i)  );
			tob[1][i]= String.valueOf( b.charAt(i)  );
			tob[2][i]= String.valueOf( c.charAt(i)  );
			tob[3][i]= String.valueOf( d.charAt(i)  );
		}
		
		int turn = sc.nextInt();
		for (int i=0;i<turn;i++) 
		{
			int index  = sc.nextInt()-1;
			int turn_flag = sc.nextInt()-1;
			m.passing(index, turn_flag);
			m.turn(index, turn_flag,index);
		}
		
		for(int i=0;i<tob.length;i++)
		{
			if(tob[i][0].equals("1")) 
			{
				answer = answer + (int)Math.pow(2, i);			
			}
		}
		
		System.out.println(answer);
		
		
		for(int i=0;i<tob.length;i++)
		{
			for(int k=0;k<tob[0].length;k++) {
				System.out.print(tob[i][k]);
			}
			System.out.println();
		}
		
		
	}

}
