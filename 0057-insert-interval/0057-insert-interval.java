class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        int i=0;
        int n=intervals.length;
        while(i<n && intervals[i][1]<newInterval[0]){
            intervalList.add(intervals[i]);
            i=i+1;
        }
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        intervalList.add(newInterval);
        while(i<n){
            intervalList.add(intervals[i]);
            i++;
        }
        return intervalList.toArray(new int[intervalList.size()][]);
    }
}