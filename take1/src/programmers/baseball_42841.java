package programmers;

import java.util.ArrayList;

public class baseball_42841 {
	
	

	 public int solution(int[][] baseball) {
	        int answer = 0;
	        ArrayList<Integer> arr = new ArrayList<Integer>();
	        for(int nn=123;nn<988;nn++) {
	        	String num = Integer.toString(nn);
	        	
	        	if (num.charAt(0)==num.charAt(1) || num.charAt(0)==num.charAt(2) ||
	    			num.charAt(1)==num.charAt(2) || 
	    			num.charAt(0)=='0' || 
	    			num.charAt(1)=='0' || 
	    			num.charAt(2)=='0') {
	        		continue;
	        	}        	
	        	
	        	 for(int i=0;i<baseball.length;i++) {          
	             	String number = Integer.toString(baseball[i][0]);               	
	         		int strike=0;
	             	int ball =0;
	             	
	             	for(int st=0;st<3;st++) {
	             		for(int ba=0;ba<3;ba++) {
	             			if (st==ba && num.charAt(st)==number.charAt(ba)) {
	             				strike++;
	             			}
	             			if (st!=ba && num.charAt(st)==number.charAt(ba)) {
	             				ball++;
	             			}
	             		}
	             	}     	
	                if (strike==baseball[i][1] && ball== baseball[i][2]) {
	                	answer++;
	                	break;
	                }      	
	             }
	        }
	        return answer;
	    }

	public static void main(String[] args) {
		baseball_42841 sol = new baseball_42841();
		int[][] baseball=new int[3][3];
		sol.solution(baseball);
		System.out.println(sol.solution(baseball));
//		String a = "123";
//		System.out.println(a.ch);
	}
	
	
}
