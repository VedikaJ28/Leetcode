class Solution {
    public int longestPalindrome(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].charAt(0)==words[i].charAt(1)){
                count=2;
                break;
            }
        }
        int c=0;
        for(int i=0;i<words.length;i++){
            if(words[i].charAt(0)!=words[i].charAt(1)){
            String reversed = new StringBuilder(words[i]).reverse().toString();
            for(int j=0;j<words.length;j++){
                if(words[j].equals(reversed)){
                    c+=2;
                }
            }
            }
        }
        System.out.println(count);
        System.out.println(c);

        return c+count;
    }
}