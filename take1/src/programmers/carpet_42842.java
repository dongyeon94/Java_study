package programmers;

import java.util.ArrayList;

public class carpet_42842 {
	
	public int[] solution(int brown, int red) {
        int[] answer = {0,0};
        
        for(int i=1;i<=red;i++) {
        	if (red%i==0) {
        		if(i>=(int)red/i) {
        			if((i+2)*2 +((int)red/i)*2==brown) {
        				int[] arrs= {i+2,(int)red/i+2};
        				return arrs;
        			}
        		}
        	}
        }
        		
        return answer;
    }
	
	
	public static void main(String[] args) {
		carpet_42842 sol = new carpet_42842();
		int[]  ss = sol.solution(10, 2);
		for(int i=0;i<ss.length;i++) {
			System.out.println(ss[i]);
		}
	}
	
}
