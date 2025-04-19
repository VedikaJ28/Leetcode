// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         long count=0;
//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]>=0 && nums[i]<=upper || nums[i]<0 && nums[i]>upper){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[j]>=0 && nums[j]<=upper|| nums[j]<0 && nums[j]>upper){
//                     if(nums[i]+nums[j]>=lower && nums[i]+nums[j]<=upper){
//                         count++;
//                     }
//                 }

//             }
//             }
//         }
//         return count;
//     }
// }
// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         long count = 0;
//         int n = nums.length;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int sum = nums[i] + nums[j];
//                 if (sum >= lower && sum <= upper) {
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            count += (right - left + 1);
        }
        return count;
    }

    private int lowerBound(int[] nums, int start, int end, int target) {
        int low = start, high = end, ans = end + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        int low = start, high = end, ans = start - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
