class Solution {
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int m= obstacleGrid.length;
    //     int n=obstacleGrid[0].length;
    //     int [][] dp= new int[m][n];
    //     for(int i=0;i<m;i++){
    //         Arrays.fill(dp[i],-1);
    //     }    
    //     int count= check(obstacleGrid, m-1, n-1, dp);
    //     return count;
    // }
    // private int check(int[][] grid, int m, int n, int[][] dp){

    //     if(m==0 && n==0 && grid[m][n]!=1){
    //         return 1;
    //     }
    //     if(m<0 || n<0){
    //         return 0;
    //     }
    //     if(m>=0 && n>=0 && grid[m][n]==1){
    //         return 0;
    //     }
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     int left = check(grid, m-1,n,dp);
    //     int up= check(grid,m,n-1,dp);
    //     return dp[m][n]=left+up;
    // }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid){

    //     int m= obstacleGrid.length;
    //     int n=obstacleGrid[0].length;
    //     if(obstacleGrid[m-1][n-1]==1) return 0;
    //     int[][] dp = new int[m][n];
    //     for(int i=0;i<n;i++){
    //         if(obstacleGrid[0][i]==1){ 
    //             break;
    //         }
    //         dp[0][i]=1;
    //     }
    //     for(int i=0;i<m;i++){
    //         if(obstacleGrid[i][0]==1){ 
    //             break;
    //         }
    //         dp[i][0]=1;
    //     }
    //     for(int i=1;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             if(obstacleGrid[i][j]==1) {
    //                 dp[i][j]=0; 
    //                 continue;
    //             }
    //             int left=0;
    //             if(j>0) left=dp[i][j-1];
    //             int up=dp[i-1][j];
    //             dp[i][j]= left+up;
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        
        int m= obstacleGrid.length;
        int n=obstacleGrid[0].length;
        
        int[] dp = new int[n];
      
        for(int i=0;i<m;i++){
            int prev=0;

            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) {
                    prev=0; dp[j]=0;
                    continue;
                    
                }
                else if(i==0 && j==0) {
                    prev=1; dp[j]=1;
                    continue;
                }
                else{            

                int up=dp[j];
                dp[j]= prev+up;
                prev= dp[j];
                }
            }
        }
        return dp[n-1];
    }
}


        
