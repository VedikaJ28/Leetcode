// class Solution {
//     public int minimumIndex(List<Integer> nums) {
//         Map<Integer, Integer> mpp = new HashMap<>(), left = new HashMap<>();
//         for (int i : nums) mpp.put(i, mpp.getOrDefault(i, 0) + 1);
        
//         for (int i = 0; i < nums.size() - 1; i++) {
//             left.put(nums.get(i), left.getOrDefault(nums.get(i), 0) + 1);
//             mpp.put(nums.get(i), mpp.get(nums.get(i)) - 1);
            
//             if (left.get(nums.get(i)) * 2 > (i + 1) && mpp.get(nums.get(i)) * 2 > (nums.size() - i - 1))
//                 return i;
//         }
//         return -1;
//     }
// }

class Solution {
    public int minimumIndex(List<Integer> nums) {
        // first finding the dominant element
        int element =findDominant(nums);
        if(element==0){
            return -1;
        }
        int splitIndex=-1;
        int count=0;
// here we are finding the first split index which we can get
        for(int i=0;i<nums.size();i++){
              if(nums.get(i)==element){
                  count++;
              }
              if(count>((i+1)/2)){
                  splitIndex=i;
                  break;
              }  
        }
        int count2=0;
// now checking if the second split array is valid or not 
        for(int i=splitIndex+1;i<nums.size();i++){
            if(element==nums.get(i)){
                count2++;
            }
        }
// if the second array is not valid 
        if(count2<=(nums.size()-(splitIndex+1))/2){
            return -1;
        }
        if(splitIndex==-1){
            return -1;
        }
        else{
            return splitIndex;
        }
    }
    public int findDominant(List<Integer> nums){
        int count=0;
        int element=0;
        for(int ele:nums){
            if(count==0){
                element=ele;
                count++;
            }
            else if(ele==element){
                count++;
            }
            else{
                count--;
            }
        }
         return element;
    }
}