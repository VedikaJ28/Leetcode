class Solution {
    public long subArrayRanges(int[] nums) {
        int [] nse= findNse(nums);
        int [] psee= findPsee(nums);
        int [] nge= findNge(nums);
        int [] pgee= findPgee(nums);
        long mod = 1000000007;
        long sumSubarrayMin=0;
        long sumSubarrayMax=0;
        for(int i=0;i<nums.length;i++){
            int left= i-psee[i];
            int right= nse[i]-i;
            sumSubarrayMin=(sumSubarrayMin + right*left*(long)nums[i])% mod;
        }
        for(int i=0;i<nums.length;i++){
            int left= i-pgee[i];
            int right= nge[i]-i;
            sumSubarrayMax=(sumSubarrayMax + right*left*(long)nums[i])% mod;
        }
        return (int)(sumSubarrayMax-sumSubarrayMin);
    }
     private int[] findNse(int [] arr){
        int [] nse= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]= st.isEmpty()? arr.length: st.peek();
            st.push(i);

        }
        return nse;

    }
    private int[] findPsee(int [] arr){
        int [] psee= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i]= st.isEmpty()? -1: st.peek();
            st.push(i);

        }
        return psee;
   }
   private int[] findNge(int [] arr){
        int [] nge= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!st.empty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            nge[i]= st.isEmpty()? arr.length: st.peek();
            st.push(i);

        }
        return nge;

    }
    private int[] findPgee(int [] arr){
        int [] pgee= new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            pgee[i]= st.isEmpty()? -1: st.peek();
            st.push(i);

        }
        return pgee;
   }
}