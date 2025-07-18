class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int zero=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
                while(zero>k){
                    if(nums[start]==0) zero--;
                    start++;
                }
            }
            
            maxLen=Math.max(maxLen,i-start+1);
               
        }
        return maxLen;
    }
}