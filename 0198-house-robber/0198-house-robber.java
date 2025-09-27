class Solution {
    public int rob(int[] nums) {
        int pick=0;
        int notPick=0;
        int [] dp= new int[nums.length];
        Arrays.fill(dp, -1);
        return check(nums.length-1, nums,dp, pick, notPick);
    }
    private int check(int i, int []nums,int[] dp, int pick, int notPick){
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        pick= nums[i]+ check(i-2, nums,dp, pick, notPick);
        notPick= 0+ check(i-1, nums,dp, pick, notPick);
        int ans= Math.max(pick,notPick);
        dp[i]= ans;
        return ans;

    }
}