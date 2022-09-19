//Link: https://practice.geeksforgeeks.org/problems/valid-expression1025/1

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            String S = sc.nextLine().trim();
            Solution ob = new Solution();
            if(ob.valid(S))
                System.out.println(1);
            else
                System.out.println(0);
        }
        sc.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean valid(String str) 
    { 
        Stack<Character> s = new Stack<>();
        for(int i = 0;  i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(ch.equals('(') || ch.equals('{') || ch.equals('[') ) {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                     return false;
                }
                else if(ch.equals(')') && s.peek().equals('(')) {
                    s.pop();
                } else if(ch.equals('}') && s.peek().equals('{')) {
                    s.pop();
                } else if(ch.equals(']') && s.peek().equals('[')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if(!s.isEmpty()) {
                return false;
            } else{
                return true;
            } 
    }
} 