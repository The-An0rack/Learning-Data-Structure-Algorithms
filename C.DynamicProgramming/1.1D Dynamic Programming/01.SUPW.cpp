#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin >> n;
	long long int dp[n];
	long long int arr[n];
	memset(dp,-1,sizeof(dp));
	for(int i = 0; i < n; i++) 
	{
	    cin >> arr[i];
	}
	dp[0] = arr[0];
	dp[1] = arr[1];
	dp[2] = arr[2];
	
	for(int i = 3; i < n; i++)
	{
	    long long int temp = min(dp[i-1],dp[i-2]);
	    temp = min(temp,dp[i-3]);
	    dp[i] = temp + arr[i];
	}
	
	long long int ans = min(dp[n-1],dp[n-2]);
	cout << min(ans,dp[n-3]);
	
	return 0;
}