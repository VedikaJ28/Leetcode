class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int maxLen=0;
        int start=0;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(map.containsKey(c) && map.get(c)>=start){
                start=map.get(c)+1;
            }
            map.put(c,i);
            maxLen=Math.max(maxLen,i-start+1);
            
        }
        return maxLen;
    }
}