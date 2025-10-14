class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length();
        int n= text2.length();
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return check(text1, text2, m-1, n-1, dp);
    }
    private int check(String a, String b, int idx1, int idx2, int[][] dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2] !=-1) return dp[idx1][idx2];
        if(a.charAt(idx1)==b.charAt(idx2)){
            return dp[idx1][idx2]= 1+ check(a,b, idx1-1,idx2-1, dp);
        }
        else{
            return dp[idx1][idx2] = Math.max(check(a,b, idx1-1, idx2, dp), check(a,b, idx1, idx2-1, dp));
        }
    }
}