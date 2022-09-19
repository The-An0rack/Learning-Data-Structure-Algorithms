//Link: https://practice.geeksforgeeks.org/problems/fab3dbbdce746976ba35c7b9b24afde40eae5a04/1

//{ Driver Code Starts
//Initial Template for Java


import java.util.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
        sc.close();
	} 
} 


// } Driver Code Ends


//User function Template for Java

class Solution {
	public int[] help_classmate(int arr[], int n) 
	{ 
	    Stack<Integer> s = new Stack<>();
	    s.push(-1);
	    int res[] = new int[n];
	    
	    for(int i = n-1; i >= 0; i--) {
	        while(s.peek().intValue() >= arr[i]) {
	            s.pop();
	        }
	        res[i] = s.peek();
	        s.push(arr[i]);
	    }
	    
	    return res;
	} 
}
