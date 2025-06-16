class Solution {
    public int maximumDifference(int[] nums) {
        int diff=-1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                int a=nums[j]-nums[i];
                if(a>diff){
                    diff=a;
                }
                }
            }
        }
        return diff;
    }
}