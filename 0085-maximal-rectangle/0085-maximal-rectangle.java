class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n= matrix.length; int m = matrix[0].length;
        int [][] preSum = new int[n][m];
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                //sum+=matrix[j][i]-'0';
                sum= (matrix[j][i]=='0') ? 0: sum+matrix[j][i]-'0';
                preSum[j][i]= sum;
            }
        }
        int maxArea=0;
        for(int i=0;i<n; i++){
            maxArea= Math.max(maxArea,largestRectangleArea(preSum[i]));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area= Integer.MIN_VALUE;
        int nse=0; int pse=0; int ele=0;
        for(int i=0;i<heights.length;i++){
            while(!st.empty() && heights[st.peek()]>heights[i]){
                ele= st.pop(); nse=i; pse= st.empty()? -1:st.peek();
                area= Math.max(area, heights[ele] *(nse-pse-1)); 
            }
            st.push(i);
        }
        while(!st.empty()){
            nse=heights.length;
            ele= st.pop();
            pse=st.empty()? -1: st.peek();
            area= Math.max(area, heights[ele] *(nse-pse-1)); 
        }
        return area;
    }
}