class Solution {
    /* MEMOIZATION
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
    */
    // TABULATION
    public int rob(int[] nums) {
        int pick=0;
        int notPick=0;
        int [] dp= new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0]=nums[0];
        int neg=0;
        for(int i=1;i<nums.length;i++){
            pick= nums[i];
            if(i>1) pick+=dp[i-2];
            notPick= dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[nums.length-1];
    }
}