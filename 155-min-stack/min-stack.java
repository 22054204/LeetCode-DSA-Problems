class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minSt;
    public MinStack() {
        stack = new Stack<>();
        minSt = new Stack<>();
    }
    public void push(int value) {
        if(minSt.isEmpty() || minSt.peek()>=value){
            minSt.push(value);
        }
        stack.push(value);
    }
    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        if (stack.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */