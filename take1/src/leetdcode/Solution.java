package leetdcode;

import java.util.*;

class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num: nums) list.add((double) num);    
        return helper(list);
    }
    
    // Take two elements -- do all operations -- adc to the list
    // continue till the list has only one element
    // see any one of them is 24
    public boolean helper(List<Double> list) {
        if(list.size() == 1) {
            if(Math.abs(list.get(0) - 24.0) < 0.1) return true;
        }
        
        
        
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++){
                double a = list.get(i);
                double b = list.get(j);
                
                List<Double> allPossible = Arrays.asList(a+b,a-b, a*b, a/b, b-a, b/a) ;                
                for(double next : allPossible) {
                    List<Double> neighbor = new ArrayList<>();
                    neighbor.add(next);
                    
                    for(int k=0; k<list.size(); k++) {
                        if( k != j && k!= i) {
                            neighbor.add(list.get(k));    
                        }
                    }
                    if(helper(neighbor)) return true;
                }
            }   
        }
        return false;
    }
}