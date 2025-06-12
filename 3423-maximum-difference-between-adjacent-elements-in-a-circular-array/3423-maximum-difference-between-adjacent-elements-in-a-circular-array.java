class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff = (int)Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=1;i<nums.length;i++){
            if((int)Math.abs(nums[i-1]-nums[i])>diff){
                diff= (int)Math.abs(nums[i-1]-nums[i]);
            }
        }
        return diff;
    }
}