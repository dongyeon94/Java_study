package programmers;

import java.util.Stack;

class Solution {
	
	class Tower{
		int idx;
		int height;
		public Tower(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}

	
	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		Stack<Tower> st = new Stack<>();
		
		for(int i=0;i<heights.length;i++) {
			Tower tower = new Tower(i + 1, heights[i]);
			int index=0;
			
			while(!st.isEmpty()) {
				Tower top = st.peek();
				if (top.height> tower.height ) {
					index =top.idx;
					break;
				}
				
				st.pop();
			}
			
			st.push(tower);
			answer[i]= index;
			
		}
		
		return answer;		 
   }
}
