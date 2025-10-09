class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i], -1);
        }
        int ans= check(coins.length-1, amount, coins, dp);
       
        return ans>=(int)1e9 ? -1 : ans ;
    }
    private int check(int idx, int tar,int[] coins , int [] [] dp){
        if(idx==0 && tar!=0){
            if(tar % coins[0]==0) return tar / coins[0];
            else return (int)1e9;
        }
        if(tar==0) return 0;
        if(dp[idx][tar]!=-1) return dp[idx][tar];
        int notPick= check(idx-1, tar, coins, dp);
        int pick= (int)1e9;
        if(coins[idx]<=tar) pick= 1+ check(idx, tar-coins[idx],coins, dp);
        return dp[idx][tar]=Math.min(notPick,pick);
    }
}