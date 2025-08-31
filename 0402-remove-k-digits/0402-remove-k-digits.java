class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(char ch: num.toCharArray()){
            int n= ch-'0';
            while(!st.empty() && k>0 && st.peek()>n){
                st.pop(); k--;
            }
            st.push(n);
        }
        while(!st.empty() && k>0){
            st.pop(); k--;       
        }
        if(st.empty()) return "0";
        Stack<Integer> str = new Stack<>();
        while(!st.empty()){
            str.push(st.pop());
        }
        while(!str.empty()&& str.peek()==0){
            str.pop();
        }
        if(str.empty()) return "0";
        StringBuilder res = new StringBuilder();
        while(!str.empty()){
            res.append(str.pop());
        }
        return res.toString();
    }
}