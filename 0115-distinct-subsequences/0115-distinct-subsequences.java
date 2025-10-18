class Solution {
    public int numDistinct(String s, String t) {      
       int [][] dp= new int[s.length()][t.length()];
       for(int i=0;i< s.length();i++){
        Arrays.fill(dp[i], -1);
       }
       return check(s,t, s.length()-1, t.length()-1, dp);
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
