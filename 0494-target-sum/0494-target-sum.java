class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if((total-target) % 2 ==1 || total<target) return 0;
        int newTarget= (total-target)/2;
        
        int[][] dp= new int[n][newTarget+1];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return check(n-1, newTarget, nums, dp);
        // for(int i=0;i<n;i++){
        //     dp[i][0]= 1;
        // }
        // if(nums[0]<=newTarget) dp[0][nums[0]]=1;
        if(nums[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if(nums[0]!=0 && nums[0]<=newTarget) dp[0][nums[0]]=1;
        for(int idx=1;idx<n;idx++){
            for(int tar=0;tar<=newTarget;tar++){
                int notPick= dp[idx-1][tar];
                int pick=0;
                if(nums[idx]<=tar) pick= dp[idx-1][tar-nums[idx]];
                dp[idx][tar]= pick+notPick;
            }
        }
        return dp[n-1][newTarget];
    }
    private int check(int idx, int tar, int []nums, int[][] dp){
        if(idx==0){
            if(tar==0 && nums[idx]==0) return 2;
            else if(tar==0 || nums[idx]==tar) return 1;
            else return 0;
        }
        if(dp[idx][tar]!=-1) return dp[idx][tar];
        int notPick = check(idx-1,tar,nums, dp);
        int pick= 0;
        if(nums[idx]<=tar) pick= check(idx-1, tar-nums[idx], nums, dp);
        return dp[idx][tar]= pick+notPick;
        
    }
}