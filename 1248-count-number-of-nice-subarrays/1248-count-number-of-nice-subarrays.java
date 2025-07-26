class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //if(goal<0) return 0;
        int l=0;
        int r=0;
        int count=0;
        int oddCount=0;
        while(r<nums.length){
            if(nums[r]%2==1) oddCount++;
            while(oddCount>k){
                if(nums[l]%2==1) oddCount--;;
                l=l+1;
            }
            count+=(r-l+1);
            r++;
        }
        return (count - numberOfSubarraysWithNewK(nums,(k-1)));
    }

    public int numberOfSubarraysWithNewK(int[] nums, int k) {
        //if(k<0) return 0;
        int l=0;
        int r=0;
        int count=0;
        int oddCount=0;
        while(r<nums.length){
            if(nums[r]%2==1) oddCount++;
            while(oddCount>k){
                if(nums[l]%2==1) oddCount--;;
                l=l+1;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}