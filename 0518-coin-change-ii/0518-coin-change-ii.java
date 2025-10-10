class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp= new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0]==0) dp[0][i]= 1;
            else dp[0][i]= 0;
        }
        for(int i=1;i<n;i++){
            for(int tar=0;tar<=amount;tar++){
                int notPick= dp[i-1][tar];
                int pick=0;
                if(coins[i]<=tar) pick= dp[i][tar-coins[i]];
                dp[i][tar]= notPick+pick;
            }
        }
        return dp[n-1][amount];
    }
}