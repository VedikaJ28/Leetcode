class Solution {
    public String minWindow(String s, String t) {
        int l=0; int r=0; int startIndex=-1; int count=0; int minLen= Integer.MAX_VALUE;
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<s.length()){
            if(map.getOrDefault(s.charAt(r),0)>0){
                count++;
            }
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)-1);
            while(count==t.length()){
                if((r-l+1)<minLen){
                    startIndex=l; minLen=r-l+1;
                }
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)+1 );
                if(map.get(s.charAt(l))>0) count--;
                l++;
            }
            r++;
        }

        return startIndex==-1? "": s.substring(startIndex,startIndex+minLen);
    }
}