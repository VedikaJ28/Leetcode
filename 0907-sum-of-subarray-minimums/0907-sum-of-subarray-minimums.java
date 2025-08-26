class Solution {
    public int sumSubarrayMins(int[] arr) {
        int [] nse= findNse(arr);
        int [] psee= findPsee(arr);
        long mod = 1000000007;
        long total=0;
        for(int i=0;i<arr.length;i++){
            int left= i-psee[i];
            int right= nse[i]-i;
            total=(total + right*left*(long)arr[i])% mod;
        }
        return (int)total;
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
}