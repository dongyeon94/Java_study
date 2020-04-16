package backjoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.text.TabExpander;

public class Test {
	
	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int[] dx = {0,  0, 1, -1}; 
	static int[] dy = {1, -1, 0,  0};
	
	public static void dfs(int x, int y,int k) {
		visit[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			if(x2 >= 0 && y2 >=0 &&  x2<N && y2<N) {
				if(visit[x2][y2] == false && map[x2][y2] >=k) dfs(x2,y2,k);
			}
			
		}

	}
	

	
	public int sol() {
		int answer = 0;
		int max=0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]= sc.nextInt();
				if (max<map[i][j]) max =map[i][j];
			}
		}
		
		for(int k=1;k<=max;k++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>=k && visit[i][j]==false) {cnt++; dfs(i,j,k);};
				}
			}
			if (cnt > answer) answer =cnt;		
		}
		
		
		System.out.println(answer);

		return answer;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test te = new Test();
		
		System.out.println(te.sol());
				
	}
}
