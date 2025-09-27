class Solution {
    public int rob(int[] nums) {
        int[] temp1 =new int[nums.length-1];
        int[] temp2 =new int[nums.length-1];
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            if(i==0) temp1[i]=nums[i];
            if(i==nums.length-1) temp2[i-1]=nums[i];
            if(i>0) temp2[i-1]=nums[i];
            if(i<nums.length-1) temp1[i]=nums[i];
        }
        return Math.max(rob1(temp1), rob1(temp2));
    }
    public int rob1(int[] nums) {
        int pick=0;
        int notPick=0;
        //int [] dp= new int[nums.length];
        //Arrays.fill(dp, -1);
        int prev=nums[0];
        int prevPrev =0;
        //int neg=0;
        for(int i=1;i<nums.length;i++){
            pick= nums[i];
            if(i>1) pick+=prevPrev;
            notPick= prev;
            int dp= Math.max(pick, notPick);
            prevPrev=prev;
            prev= dp;
            
        }
        return prev;
    }
}