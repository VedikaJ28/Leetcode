class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        checkSubstrings(result, new ArrayList<>(), s, 0);
        return result;
    }
    public void checkSubstrings(List<List<String>> result, List<String> tempArr,String s, int start){
        if(start==s.length()){
            result.add(new ArrayList<>(tempArr));
            return;
        }
        for(int i=start; i<s.length();i++){
            if(isPalindrome(s,start,i)){
                tempArr.add(s.substring(start,i+1));
                checkSubstrings(result,tempArr,s,i+1);
                tempArr.remove(tempArr.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }
}