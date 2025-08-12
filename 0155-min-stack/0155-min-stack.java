// class MinStack {
//     Stack<List<Integer>> st;
//     public MinStack() {
//         st = new Stack<>();
//     }
    
//     public void push(int val) {
//         if(st.empty()) st.push(Arrays.asList(val,val));
//         else{
//             st.push(Arrays.asList(val,Math.min(val,st.peek().get(1))));
//         }
//     }
    
//     public void pop() {
//         st.pop();
//     }
    
//     public int top() {
//         return st.peek().get(0);
//     }
    
//     public int getMin() {
//         return st.peek().get(1);
//     }
// }

class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min= Long.MAX_VALUE;
    }
    
    public void push(int val) {
        long v=val;
        if(st.empty()) {st.push(v); min=v;}
        else{
            if(v>=min) st.push(v);
            else{
                st.push((2*v)-min);
                min=v;
            }
        }
    }
    
    public void pop() {
        if(st.empty()) return;
        long n=st.peek();
        st.pop();
        if(n<min) min=2*min-n;
    }
    
    public int top() {
        if(st.empty()) return -1;
        long n=st.peek();
        if(min<n) return (int)n;
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
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