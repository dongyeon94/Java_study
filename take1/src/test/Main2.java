package test;

import java.util.Scanner;

public class Main2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.println(10/4);
//		나눴을때 0이거나 0이 아닌데 %가 0이면 끝
		long hp=0;
		int room = sc.nextInt();
		int attack = sc.nextInt();
		
		
		for(int i=0;i<room;i++) {
			int type = sc.nextInt();
			if (type==1) {
				int mon_attactk =sc.nextInt();
				int mon_hp = sc.nextInt();				
				if( mon_hp/attack!=0)  {
					int ssss =mon_hp/attack-1 ;
					if (mon_hp%attack==0) {						
						long ss = mon_attactk*(mon_hp/attack-1);
						for(int kk=0;kk<mon_hp/attack-1;kk++) {
							hp += mon_attactk;
						}
//						hp += ss;
					}
					else {
						long ss =mon_attactk*(mon_hp/attack);
						for(int kk=0;kk<mon_hp/attack;kk++) {
							hp += mon_attactk;
						}
//						hp += ss;					
					}					
				}
			}
			else {
				attack +=sc.nextInt();
				hp -= sc.nextInt();
			}
			if (hp<0)hp=0;
		}
		
		System.out.println(hp+1);
		
	}

}
