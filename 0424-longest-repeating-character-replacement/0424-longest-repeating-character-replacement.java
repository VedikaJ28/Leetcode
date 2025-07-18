class Solution {
    public int characterReplacement(String s, int k) {
        int start=0;
        int maxLen=0;
        int maxFreq=0;
        int update=0;
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq= Math.max(maxFreq,map.get(c));
            if((i-start+1)-maxFreq>k){
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                start++;
            }
            maxLen=Math.max(maxLen,i-start+1);
        }
        return maxLen;
    }
}