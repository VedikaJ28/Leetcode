class Solution {
    public int countDays(int days, int[][] meetings) {
        int count=0;
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        //int coveredStart= meetings[0][0];
        int coveredEnd=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            if(coveredEnd<meetings[i][0]){
                count+=meetings[i][0]-coveredEnd-1;
                //coveredStart=meetings[i][0];
                coveredEnd=meetings[i][1];
            }
            else{
                coveredEnd=Math.max(meetings[i][1],coveredEnd);
            }
        }
        // for(int i=meetings.length-1;i>0;i--){
        //     if(meetings[i][1]-meetings[i-1][1]>=meetings[i][0]-meetings[i-1][1] && meetings[i][1]-meetings[i-1][1]!=0 && meetings[i][0]-meetings[i-1][1]>0){
        //         count+=meetings[i][0]-meetings[i-1][1]-1;
        //     }
        // }
        if(meetings[0][0]!=1){
            count+=meetings[0][0]-1;
        }
        if(coveredEnd!=days){
            count+=days-coveredEnd;
        }
        return count;
    }
}