// class Solution {
//     public long maximumTripletValue(int[] nums) {
//         int k=0;
//         int kPos=0;
//         int max=0;
//         int pos=0;
//         for(int i=2;i<nums.length;i++){
//             if(nums[i]>=max){
//                 max=nums[i];
//                 pos=i;
//             }
//         }
//         k=max; kPos=pos;
//         int max1=0; 
//         int max1Pos=-1; 
//         int min1Pos=0;
//         int min1=Integer.MAX_VALUE;
//         for(int i=0;i<kPos-1;i++){
//             if(nums[i]>max1){
//                 max1=nums[i];
//                 max1Pos=i;
//             }
            
//         }
//         for(int i=max1Pos+1;i<kPos;i++){
//             if(nums[i]<min1){
//                 min1=nums[i];
//             }
//         }
//         // System.out.println(max1);
//         // System.out.println(min1);
//         // System.out.println(k);
        
//         if (max1Pos == -1 || min1 == Integer.MAX_VALUE) return 0;

//         // Step 4: Compute the result
//         long ans = (long) (max1 - min1) * k;
//         return Math.max(ans, 0);
//     }
// }
class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxElement - num);
            maxElement = Math.max(maxElement, num);
        }
        return maxTriplet;
    }
}
