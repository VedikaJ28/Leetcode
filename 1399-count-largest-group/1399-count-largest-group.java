class Solution {
    public int countLargestGroup(int n) {
        if(n<=10){
            return n;
        }
        
        else{
            HashMap<Integer,Integer> cntGrp= new HashMap<>();
            int maxCount=0;
            int count=0;
            for(int i=1;i<=n;i++){
                int no=i;
                int sum=0;
                while(no>0){
                    sum+=no%10;
                    no=no/10;
                }
                cntGrp.put(sum,cntGrp.getOrDefault(sum,0)+1);
                maxCount= Math.max(maxCount,cntGrp.get(sum));
            }
            for(int val: cntGrp.values()){
                if(val==maxCount){
                    count++;
                }
            }
            return count;       
        }
        
    }
}