class Solution {
    public int possibleStringCount(String word) {
        int n=word.length();
        int count=n;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(i-1)){
                count--;
            }
        }
        return count;
        // HashMap<Character,Integer> charCount = new HashMap<>();
        // int count=0;
        // int count1=0;
        // for(char ch: word.toCharArray()){
        //     charCount.put(ch,charCount.getOrDefault(ch,0)+1);
        // }
        // for(Map.Entry<Character,Integer> entry:charCount.entrySet()){
        //     if(entry.getValue()>1){
        //         count+=(entry.getValue()-1);
        //     }
        //     else{
        //         count1+=1;
        //     }
        // }
        // if(count1==word.length()){
        //     return 1;
        // }
        // return count+1;
    }
}