package backjoon;

import java.util.*;

public class P_10451 {
	public static void dfs(int[] arr, boolean[] visited, int index) {
		if (visited[index]) return;
		visited[index] = true;
		dfs(arr,visited,arr[index]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
				
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		
		while (t>0) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			boolean[] visited = new boolean[n+1]; 
			t--;
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
				visited[i] = false;
			}
			
			for(int i=1;i<=n;i++) {
				if (visited[i]==false) {
					dfs(arr,visited,i);
					answer ++;
				}
			}
			System.out.println(answer);
			answer = 0;
		}
		
	}

}
