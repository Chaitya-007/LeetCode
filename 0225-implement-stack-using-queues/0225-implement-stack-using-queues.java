class MyStack {
        Queue<Integer> q ;

    public MyStack() {
         q = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        q.offer(x);

        for(int i = 1; i < q.size(); i++)
        {
            q.offer(q.peek());
            q.poll();
        }

    }
    
    public int pop() {

        int element = q.poll();
        return element;
    }
    
    public int top() {
        
        return q.peek();
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