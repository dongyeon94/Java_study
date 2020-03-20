package programmers;

import java.util.Stack;

public class IronStick_42585 {

	public int solution(String arrangement) {
        int answer = 0;
        arrangement = arrangement.replace("()", "1");
        
        Stack st = new Stack();
        for(int i=0;i<arrangement.length();i++) {
        	if (arrangement.charAt(i)=='(') {
        		st.push(arrangement.charAt(i));
        	}
        	else if (arrangement.charAt(i)==')') {
        		st.pop();
        		answer++;
        	}
        	else if (arrangement.charAt(i)=='1') {
        		answer += st.size();
        		}
        	
        }
        
        
        return answer;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a="1234";
		System.out.println(a.charAt(0));
		
	}

}
