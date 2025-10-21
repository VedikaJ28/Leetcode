class Solution {
    public boolean isMatch(String s, String p) {
        int m= s.length();
        int n= p.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return check(s,p, m-1, n-1, dp)==1;
    }
    private int check(String s, String p, int i, int j, int[][] dp){
        if(i<0 && j<0) return 1;
        if(j<0 && i>=0) return 0;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*'){
                    return 0;
                }
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==p.charAt(j)|| p.charAt(j)=='?'){
            return dp[i][j] = check(s, p, i-1, j-1, dp);
        }
        else if(p.charAt(j)=='*'){
            // * matches to no charcter, * matches to one or more character
            return dp[i][j]= (check(s, p,i ,j-1 , dp)==1 | check(s, p,i-1 , j, dp)==1)? 1: 0;
        }
        else{
            return dp[i][j]= 0;
        }
    }
}