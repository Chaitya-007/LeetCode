class MyStack {
    ArrayDeque<Integer> q = new ArrayDeque<Integer>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.offerLast(x);
        
    }
    
    public int pop() {
        // if(q.isEmpty())
        // {

        // }

        int x = q.peekLast();
        q.pollLast();
        return x;
        
    }
    
    public int top() {
        int x = q.peekLast();
        return x;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */