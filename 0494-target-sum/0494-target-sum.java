class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        if((total-target) % 2 ==1 || total<target) return 0;
        int newTarget= (total-target)/2;
        
        int[][] dp= new int[nums.length][newTarget+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return check(nums.length-1, newTarget, nums, dp);
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