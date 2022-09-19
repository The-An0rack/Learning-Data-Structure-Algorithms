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

    int solve(int[] dp,int N) {
        if(N == 1) {
            return 0;
        }
        if(dp[N] != -1) {
            return dp[N];
        }
        
        int ans = solve(dp, N - 1);
        if(N%2 == 0) {
            ans = Math.min(ans, solve(dp,N/2));
        }
        if(N%3 == 0) {
            ans = Math.min(ans, solve(dp, N/3));
        }
        
        dp[N] = ans + 1;
        return dp[N];
    }

	public int minSteps(int N) 
	{ 
	    int dp[] = new int[N+1];
	    for(int i = 0; i <= N; i++) {
	        dp[i] = -1;
	    }
	    
	    return solve(dp,N);
	} 
}
