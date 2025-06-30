class Solution {
    public int findLHS(int[] nums) {
        Map <Integer,Integer> map = new HashMap<>();
        int n = nums.length;


        for(int i = 0; i<n; i++){
              map.put(nums[i], map.getOrDefault(nums[i], 0) +1);  
        }
        int maxlen=0;
        for(Integer key : map.keySet()){
            if(map.containsKey(key+1)){
             int sublen = map.get(key)+map.get(key+1);
             maxlen = Math.max( maxlen,sublen);
            }
        }

        return maxlen;
    }
}