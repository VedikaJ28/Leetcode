class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();

        // int idx=0;
        // int row=0;

        // int[][] dp= new int[n][n];
        // //dp.get(0).set(0, triangle.get(0).get(0));
        // for(int i=0;i<n;i++){
        //    Arrays.fill(dp[i],-1);
        // }
        
        // return check(triangle, idx, row, dp);

        int[] dp= new int[n];
        for(int i=0;i<n;i++){
            dp[i]= triangle.get(n-1).get(i);
        }
        for(int row= n-2; row>=0; row--){
            for(int col=0; col<=row;col++){
                dp[col]= triangle.get(row).get(col)+ Math.min(dp[col], dp[col+1]);
            }
        }
        return dp[0];
    }
    // private int check(List<List<Integer>> tri, int idx,int row, int[][] dp){
    //     if(dp[row][idx]!=-1) return dp[row][idx];
    //     if(row==tri.size()-1){
    //        return tri.get(row).get(idx);
    //     }
        
    //     //int rowSize= triangle.get(row).size();
    //     int i= check(tri, idx, row+1, dp);
    //     int iPlus1= check(tri, idx+1, row+1, dp);
    //     int value= tri.get(row).get(idx)+ Math.min(i, iPlus1);
    //     dp[row][idx]=value;
    //     return value;

    // }
}