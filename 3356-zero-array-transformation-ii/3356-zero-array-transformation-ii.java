class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
         if(Arrays.stream(nums).allMatch(num -> num == 0)==true){
                return 0;
            }
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0];j<=queries[i][1];j++){
                if(queries[i][2]-nums[j]>0){
                    nums[j]=0;
                }
                else{
                    nums[j]-=queries[i][2];
                }
            }
            if(Arrays.stream(nums).allMatch(num -> num == 0)==true){
                return i+1;
            }
        }
        return -1;
    }
}