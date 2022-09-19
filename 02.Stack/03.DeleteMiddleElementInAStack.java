//Link https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

//{ Driver Code Starts
//Initial template for Java

import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        sc.close();
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void Solve(Stack<Integer> s, int sizeOfStack, int curr) {
        if(curr == sizeOfStack/2) {
            s.pop();
            return;
        } 
        
        Integer ele = s.pop();
        Solve(s,sizeOfStack,curr+1);
        s.push(ele);
    }
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        Solve(s,sizeOfStack,0);
    } 
}

