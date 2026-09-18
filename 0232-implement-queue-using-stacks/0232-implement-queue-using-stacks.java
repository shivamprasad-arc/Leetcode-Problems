class MyQueue {
   Stack<Integer>  helperSt;
    Stack<Integer> mainSt;
    public MyQueue() {
        mainSt = new Stack<>();
        helperSt = new Stack<>();
    }
    
    public void push(int x) {
        helperSt.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        if(mainSt.isEmpty()){ 
        while(!helperSt.isEmpty()){
            mainSt.push(helperSt.pop());
        }
        }
        return mainSt.pop();
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        if(mainSt.isEmpty()){
        while(!helperSt.isEmpty()){
            mainSt.push(helperSt.pop());
        }
        }
        return mainSt.peek();
    }
    
    public boolean empty() {
        return helperSt.isEmpty() && mainSt.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */