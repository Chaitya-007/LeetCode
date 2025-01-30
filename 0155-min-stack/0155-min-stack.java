class MinStack {
    // Stack<Integer> st = new Stack<Integer>();
    LinkedList<Integer> ll = new LinkedList<Integer>();
    // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    Stack<Integer> st = new Stack<Integer>();

    public MinStack() {
        
    }
    
    public void push(int val) {
    //    pq.offer(val);
    ll.addFirst(val);
       st.push(val);
    }
    
    public void pop() {
    //    pq.poll();
    ll.pollFirst();
        st.pop();
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
    // int mino = Integer.MAX_VALUE;
    // return pq.peek();

    // int mino = Integer.MAX_VALUE;
    // for(Integer val : ll)
    // {

    // }

    int mino = Collections.min(ll);
    return mino;

    
        
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