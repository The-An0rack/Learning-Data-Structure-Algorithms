//{ Driver Code Starts
    import java.util.*;
    
    class RodCutting {
    
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    
                Solution ob = new Solution();
                System.out.println(ob.cutRod(arr, n));
            }
            sc.close();
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution{
        
        int solve(int[] price, int n, int[] dp) {
            if(n == 0) {
                return 0;
            }
            
            if(dp[n] != -1) return dp[n];
            
            int ans = 0;
            for(int i = 1; i <= n; i++ ) {
                ans = Math.max(ans, price[i-1] + solve(price, n - i, dp));
            }
            
            dp[n] = ans;
            return ans;
        }
        
        public int cutRod(int price[], int n) {
            int[] dp = new int[n+1];
            
            for(int i = 0; i <= n; i++) {
                dp[i] = -1;
            }
            
            dp[0] = 0;
            
            return solve(price,n,dp);
        }
    }