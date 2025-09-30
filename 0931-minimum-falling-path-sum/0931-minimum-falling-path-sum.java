class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        if(m==1 && n==1) return matrix[0][0];
        int []dp= new int[n];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            dp[i]= matrix[m-1][i];
        }
        for(int i=m-2;i>=0;i--){
            int []temp= new int[n];
            for(int col=0;col<n;col++){
                int leftDiag = Integer.MAX_VALUE;
                int rightDiag = Integer.MAX_VALUE;
                if(col>0) leftDiag= dp[col-1];
                if(col<n-1) rightDiag= dp[col+1];
                int bottom= dp[col];    
                temp[col]= matrix[i][col]+ Math.min(Math.min(leftDiag, rightDiag), bottom);
                if(i==0){
                    ans=Math.min(ans,temp[col]);
                }
            }
            dp=temp.clone();     
        }
        return ans;
    }
}