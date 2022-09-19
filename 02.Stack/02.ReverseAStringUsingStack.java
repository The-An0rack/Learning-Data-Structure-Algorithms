// Link: https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1

//

import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }

        sc.close();
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            s.push(S.charAt(i));
        }
        
        String res = "";
        while(!s.isEmpty()) {
            res += s.pop();
        }
        
        return res;
    }

}