//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minSteps(n));
                    
                }
            sc.close();
        }

}    
// } Driver Code Ends


class Solution{

	public int minSteps(int N) 
	{ 
	    int[] dp = new int[N+1];
	    
	    dp[1] = 0;
	    
	    for(int i = 2; i <= N; i++ ) {
	        int ans = dp[i-1];
	        if(i%2 == 0) {
	            ans = Math.min(ans, dp[i/2]);
	        }
	        if(i%3 == 0) {
	            ans = Math.min(ans, dp[i/3]);
	        }
	        
	        dp[i] = ans+1;
	        
	    }
	    return dp[N];
	} 
}
