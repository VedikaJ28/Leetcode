class Solution {
    public boolean lemonadeChange(int[] bills) {
        int amt=0;
        int i=0;
        int countFive=0; int countTen=0; int countTwenty =0;
        for(i=0;i<bills.length;i++){
            if(bills[i]==5){
                countFive++;
            }
            else if(bills[i]==10){
                if(countFive>=1){
                    countFive--;
                    countTen++;
                }
                else{return false;}
            }
            else{
                if(countTen>=1 && countFive>=1){
                    countTen--; countFive--; countTwenty++;
                }
                else if(countFive>=3){
                    countFive-=3;
                    countTwenty++;
                }
                else{return false;}
            }
        }
        //System.out.println(i);
        return true;
    }
}