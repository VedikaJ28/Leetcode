class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //if(goal<0) return 0;
        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l=l+1;
            }
            count+=(r-l+1);
            r++;
        }
        return (count - numSubarraysWithNewGoal(nums,(goal-1)));
    }

    public int numSubarraysWithNewGoal(int[] nums, int goal) {
        if(goal<0) return 0;
        int l=0;
        int r=0;
        int count=0;
        int sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l=l+1;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}