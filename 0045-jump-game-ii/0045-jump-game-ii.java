class Solution {
    public int jump(int[] nums) {
        int i=0; int jumps=0;
        while(i<nums.length-1){
            int maxReach=0;
            int nextPos=i;
            int l=i+1; int r=i+nums[i];
            if(r>=nums.length-1){
                jumps++;
                break;
            }
            for(int j=l;j<=r;j++){
                if(nums[j]+j>maxReach){
                    maxReach=j+nums[j];
                    nextPos=j;
                }
            }
            jumps++;
            i=nextPos;
        }
        return jumps;
    }
}