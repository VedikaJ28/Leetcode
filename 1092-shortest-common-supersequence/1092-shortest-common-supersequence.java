class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String s1= longestCommonSubsequence(str1, str2);
        return new StringBuilder(s1).reverse().toString();
    }
    private String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            char text1_i = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (text2.charAt(j - 1) == text1_i) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    //System.out.print(text1_i);
                   
                } 
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //System.out.print(dp.toString());
        return printLongestCommonSubSuper(dp, m,n, text1, text2 );
    }

    private String printLongestCommonSubSuper(int[][] dp, int m, int n, String a, String b){
        StringBuilder str= new StringBuilder();
        int i= m;
        int j=n;
        while(i>0 && j>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                str.append(a.charAt(i-1));
                i--; j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                str.append(a.charAt(i-1));
                    i--;    
                }
            else{
                str.append(b.charAt(j-1));
                j--;
                }
            }

           while(i>0){
            str.append(a.charAt(i-1));
            i--;
           }
           while(j>0){
            str.append(b.charAt(j-1));
            j--;
           }

            return str.toString();
        }
    
}