class Solution {
    public boolean canPartition(int[] nums) {
        int numsSum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numsSum += nums[i];
        }

        if (numsSum % 2 == 1) {
            return false;
        }
        int k = numsSum / 2;
        boolean[] prev = new boolean[k + 1];
        prev[0] = true;
        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[k + 1];
            prev[0] = true;
            if (nums[0] <= k)
                prev[nums[0]] = true;
            for (int target = 1; target <= k; target++) {
                boolean take = false;
                if (nums[ind] <= target) {
                    take = prev[target - nums[ind]];
                }
                boolean notTake = prev[target];
                curr[target] = take || notTake;
            }
            prev = curr;
        }
        return prev[k];
    }

}