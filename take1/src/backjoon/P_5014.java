package backjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class P_5014 {
	 public static void sol() {
  	   Scanner scan=new Scanner(System.in);
  	   int F=scan.nextInt();//경계
  	   int S=scan.nextInt();//현위치
  	   int G=scan.nextInt();//도착위치
  	   int U=scan.nextInt(); //위로 몇층
  	   int D=scan.nextInt();//아래로 몇층
  	   

	   Queue<Integer> queue=new LinkedList<>();
	   int[] dist=new int[10000001];
	   Set<Integer> check=new HashSet<>();
	   
	   queue.add(S);
	   dist[S]=0;
	   check.add(S);
	   
	   while(!queue.isEmpty()) {
		   int now=queue.poll();
		   if(now==G) {
			   System.out.println(dist[now]);
			   return;
		   }
		   
		   //위로올라갈수있다면?
		   if(now+U<=F && !check.contains(now+U)) {
			   dist[now+U]=dist[now]+1;
			   check.add(now+U);
			   queue.add(now+U);
		   }
		   
		   //아래로내려갈수있다면?
		   if(now-D>0 && !check.contains(now-D)) {
			   dist[now-D]=dist[now]+1;
			   check.add(now-D);
			   queue.add(now-D);
		   }
	   }
	   
	   System.out.println("use the stairs");
	   
	 }
}
