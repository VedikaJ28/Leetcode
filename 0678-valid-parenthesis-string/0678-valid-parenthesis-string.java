class Solution {
    public boolean checkValidString(String s) {
        int i=0;
        int count=0;
        int specialChar=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                count++;
            }
            else if(s.charAt(i)==')'){
                if(count>0){
                    count--;
                    //specialChar--;
                }
                else if(specialChar>0){
                    specialChar--;
                }
                else{
                    return false;
                }
            }
            else{
                specialChar++;
            }
            i++;
        }
        if(count==0||count==specialChar){
            return true;
        }
        return false;
    }
}