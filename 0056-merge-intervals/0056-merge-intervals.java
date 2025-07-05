class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->Integer.compare(a[0],b[0]));
        List <int[]> merge =new ArrayList<>();
        int [] currInt=intervals[0];
        System.out.println(Arrays.toString(currInt));
        for(int i=1;i<intervals.length;i++){
            if(currInt[1]>=intervals[i][0]){
                currInt[1]=Math.max(intervals[i][1],currInt[1]);
                System.out.println("1" +Arrays.toString(currInt));
            }
            else{
                merge.add(currInt);
                currInt=intervals[i];
                System.out.println("2" +Arrays.toString(currInt));
                
            }
            
            /*
            if(intervals[i][1]>intervals[i+1][0] || intervals[i][1]==intervals[i+1][0]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
                //merge.add(new int[]{intervals[i+1][0],intervals[i+1][1]});
            }
            else{
                if(i==intervals.length-2){
                    merge.add(new int[]{intervals[i][0],intervals[i][1]});
                    merge.add(new int[]{intervals[i+1][0],intervals[i+1][1]});

                }
                else{
                    merge.add(new int[]{intervals[i][0],intervals[i][1]});
                }
            }*/
        }
        System.out.println(Arrays.toString(currInt));
        merge.add(currInt);
        return merge.toArray(new int[merge.size()][]);
    }
}