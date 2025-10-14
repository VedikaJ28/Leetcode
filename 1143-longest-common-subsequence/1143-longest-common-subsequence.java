class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m= text1.length();
        int n= text2.length();
        int[][] dp= new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return check(text1, text2, m-1, n-1, dp);
        char text1_0= text1.charAt(0);
        char text2_0= text2.charAt(0);        
        for(int i=0;i<n;i++){
            if(text2.charAt(i)==text1_0) dp[0][i]= 1;
        }
        for(int i=0;i<m;i++){
            if(text1.charAt(i)==text2_0) dp[i][0]= 1;
        }
        for(int i=1;i<m;i++){
            char text1_i= text1.charAt(i);
            for(int j=1;j<n;j++){
                if(text2.charAt(j)==text1_i) dp[i][j]= 1+ dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.print(dp.toString());
        return dp[m-1][n-1];
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