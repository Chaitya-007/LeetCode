class MinStack {
// T.C -> O(1)
// S.C -> O(2 * N)
    Stack<Pair<Integer, Integer>> st;
    int minElement = 0;

    public MinStack() {
     st = new Stack<>();   
    minElement = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
    if(st.isEmpty())
    {
        minElement = val;
     st.push(new Pair<Integer,Integer>(val, val));

    }
    else
    {
       minElement = st.peek().getValue();
       minElement = Math.min(minElement,val);
     st.push(new Pair<Integer,Integer>(val, minElement));
    }
    }
    
    public void pop() {
        st.pop();
        
    }
    
    public int top() {
        int topval = st.peek().getKey();
        return topval;
    }
    
    public int getMin() {
        int minVal = st.peek().getValue();
        return minVal;
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