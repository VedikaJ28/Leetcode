class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        int count=0;
        while(i<s.length && j<g.length){
            if(s[i]>=g[j]){
                count++;
                i++; j++;
            }
            else{
                i++;
            }
        }
        return count;
    }
}