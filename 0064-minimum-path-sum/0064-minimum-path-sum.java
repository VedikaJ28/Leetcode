class Solution {
    public int minPathSum(int[][] grid) {
        int sum=0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
        
        Arrays.fill(dp[i], -1);
        }
        int count = check(grid, m - 1, n - 1, dp);

        return count;
    }

    private int check(int[][] grid, int m, int n, int[][] dp) {
      
        if (m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        if(m==0 && n==0) return grid[0][0];
        if (dp[m][n] != -1){
            return dp[m][n];
        }

        int up =check(grid, m - 1, n, dp);
        int left = check(grid, m, n - 1, dp);
        

        return dp[m][n] = grid[m][n] + Math.min(left,up);

    }
}