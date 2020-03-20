package take1;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
	
	
	 public int solution(int[] budgets, int M) {
	    	int num=0;
	    	int get = M/budgets.length;
	    	double get_ou = (double)M / (double)budgets.length -get;
	    	int bud=0;
	    	for(int i=0;i<budgets.length;i++) {
	    		if(budgets[i]>get) {num++;}
	    		else {bud = bud + get-budgets[i];}
	    	}
	        int answer = get +bud/num +(int)get_ou*num;
	        return answer;
	    }
        
//        return answer;

	 
	public static void main(String[] args){
		Solution sol = new Solution();
		int[] a = {120, 110, 140, 150};
		System.out.println(sol.solution(a, 485));
		
	}
}