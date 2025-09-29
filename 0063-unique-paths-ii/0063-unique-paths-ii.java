class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }    
        int count= check(obstacleGrid, m-1, n-1, dp);
        return count;
    }
    private int check(int[][] grid, int m, int n, int[][] dp){
        
        if(m==0 && n==0 && grid[m][n]!=1){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(m>=0 && n>=0 && grid[m][n]==1){
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int left = check(grid, m-1,n,dp);
        int up= check(grid,m,n-1,dp);
        return dp[m][n]=left+up;
    }
}