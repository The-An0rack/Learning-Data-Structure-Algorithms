//Link: https://practice.geeksforgeeks.org/problems/e015cb4d3f354b035d9665e7c8a54a7aefb1901b/1

//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                String s; 
                s = br.readLine();
                
                Solution obj = new Solution();
                int res = obj.checkRedundancy(s);
                
                System.out.println(res);
                
            }

            br.close();
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
        public int checkRedundancy(String str) {
            Stack<Character> s = new Stack<>();
            
            for(int i = 0; i < str.length(); i++) {
                Character ch= str.charAt(i);
                if(ch.equals('(') || ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/')) {
                    s.push(ch);
                } else {
                    if(ch.equals(')')) {
                        if(s.peek().equals('(')) {
                            return 1;
                        } else {
                            while(!s.peek().equals('(')) {
                                s.pop();
                            }
                            s.pop();
                        }
                    }
                }
            }
            
            return 0;
        }
    }
            
    