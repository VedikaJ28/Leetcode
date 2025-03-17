class Solution {
    public boolean divideArray(int[] nums) {
        int [] freq=new int[501];
        int pairs=nums.length/2;
        int count=0;
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]%2==1){
                return false;
            }
            else{
                count+=freq[i]/2;
            }
        }
        return (count==pairs? true:false);
    }
}