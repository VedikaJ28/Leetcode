class Solution {
    public int findNumbers(int[] nums) {
        int count1=0;
        for(int i=0;i<nums.length;i++){
            int no=nums[i];
            int count=0;
            while(no>0){
                count++;
                no=no/10;
            }
            if(count%2==0){
                count1++;
            }
        }
        return count1;
    }
}