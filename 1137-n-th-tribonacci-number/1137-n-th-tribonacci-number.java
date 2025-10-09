class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        // int prev=1;
        // int prevPrev=1;
        // int prevPrevPrev=0;
        // int curr=0;
        // for(int i=3;i<=n;i++){
        //     curr= prevPrevPrev+prevPrev+prev;
        //     prevPrevPrev=prevPrev;
        //     prevPrev=prev;
        //     prev=curr;
        // }
        // return prev;

        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}