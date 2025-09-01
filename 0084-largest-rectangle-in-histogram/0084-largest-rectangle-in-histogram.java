class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area= Integer.MAX_VALUE;
        for(int i=0;i<heights.length;i++){
            while(!st.empty() && heights[st.peek()]>heights[i]){
                int ele= st.pop(); nse=i; pse= st.empty()? -1:st.peek();
                area= Math.max(area, heights[ele] *(nse-pse-1)); 
            }
            st.push(i);
        }
        while(st.empty){
            nse=-1;
            ele= st.pop();
            pse=st.empty()? -1: st.peek();
            area= Math.max(area, heights[ele] *(nse-pse-1)); 
        }
        return area;
    }
}