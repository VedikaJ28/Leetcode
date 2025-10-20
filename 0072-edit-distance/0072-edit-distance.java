class Solution {
    public int minDistance(String word1, String word2) {
        int m= word1.length();
        int n= word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return check(word1, word2, m-1, n-1, dp);
    }
    private int check(String a, String b, int m, int n, int[][] dp){
        if(m<0) return n+1;
        if(n<0) return m+1;
        if(dp[m][n]!=-1) return dp[m][n];
        if(a.charAt(m)==b.charAt(n)){
            return dp[m][n] = check(a, b, m-1, n-1, dp);
        }
        else{
            int insert = check(a,b, m, n-1, dp);
            int delete = check(a,b, m-1, n, dp);
            int replace = check(a, b, m-1, n-1, dp);
            return dp[m][n] = 1+ Math.min(replace, Math.min(insert, delete));
        }
    }
}