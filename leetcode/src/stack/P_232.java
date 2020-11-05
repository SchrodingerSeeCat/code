package stack;

import java.util.Stack;

public class P_232 {
    class MyQueue {
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            inStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            checkOutStack();
            return outStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            checkOutStack();
            return outStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return outStack.isEmpty() && inStack.isEmpty();
        }

        private void checkOutStack() {
            if (outStack.isEmpty()) {
                while(!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
