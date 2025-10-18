class Solution {
    public int numDistinct(String s, String t) { 
        int m= s.length(); 
        int n =t.length();    
       int [][] dp= new int[m][n];
    //    for(int i=0;i< s.length();i++){
    //     Arrays.fill(dp[i], -1);
    //    }
    //     int ans= check(s,t, s.length()-1, t.length()-1, dp);
    //    for(int i=0;i<s.length();i++){
    //     for(int j=0;j<t.length();j++){
    //         System.out.print(dp[i][j]);
    //     }
    //     System.out.println();
    //    }
    //    return ans;


    if(s.charAt(0)==t.charAt(0)) dp[0][0]=1;

    for(int i=1;i<m;i++){
        char s_i= s.charAt(i);
        for(int j=0;j<n;j++){
            if(s_i!= t.charAt(j)) dp[i][j]= dp[i-1][j];
            else{
                dp[i][j]= dp[i-1][j];
                if(j>0) dp[i][j]+= dp[i-1][j-1];
                else dp[i][j]+=1;
            }
        }
    }
    return dp[m-1][n-1];
    }
    private int check(String s, String t, int i, int j, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            int pick= check(s,t, i-1, j-1, dp);
            int notPick= check(s, t, i-1,j, dp);
            return dp[i][j]= pick+notPick;
        }
        else{
            return dp[i][j]= check(s,t,i-1,j,dp);
        }
    }
   

}
