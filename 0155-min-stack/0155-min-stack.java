class MinStack {
    Stack<List<Integer>> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.empty()) st.push(Arrays.asList(val,val));
        else{
            st.push(Arrays.asList(val,Math.min(val,st.peek().get(1))));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().get(0);
    }
    
    public int getMin() {
        return st.peek().get(1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */