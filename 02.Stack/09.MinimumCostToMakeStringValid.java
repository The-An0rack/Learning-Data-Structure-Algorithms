//Link: https://www.codingninjas.com/codestudio/problems/minimum-cost-to-make-string-valid_1115770?leftPanelTab=0

import java.util.*;

class Solution {
    public static int findMinimumCost(String str) {
		// Write your code here
        if(str.length()%2 == 1) {
            return -1;
        } else {
            Stack<Character> s = new Stack<>();
            for(int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                if(ch.equals('{')) {
                    s.push(ch);
                } else {
                    if(!s.isEmpty() && ch.equals('}') && s.peek().equals('{')) {
                        s.pop();
                    } else {
                        s.push(ch);
                    }
                }
            }
            
            int a = 0, b = 0;
            while(!s.isEmpty()) {
                Character ch = s.pop();
                if(ch.equals('{')) {
                    a++;
                } else {
                    b++;
                }
            }
            
            return ((a+1)/2 + (b+1)/2);
        }
        
        
    }
}