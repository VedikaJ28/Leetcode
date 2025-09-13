class StockSpanner {
    Stack<int []> st = new Stack<>();
    int idx= -1;
    public StockSpanner() {
        idx=-1; st.clear();
    }
    
    public int next(int price) {
        idx+=1;
        while(!st.empty() && st.peek()[0]<=price) {st.pop();}
        
        int ans= idx - (st.empty()? -1: st.peek()[1]);
        st.push(new int[]{price,idx});
        return ans;
    }
//     private int[] findPge(int [] arr){
//         int [] pge= new int[arr.length];
//         Stack<Integer> st = new Stack<>();
//         for(int i=0;i<arr.length;i++){
//             while(!st.empty() && arr[st.peek()]<=arr[i]){
//                 st.pop();
//             }
//             pge[i]= st.isEmpty()? -1: st.peek();
//             st.push(i);

//         }
//         return pge;
//    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */