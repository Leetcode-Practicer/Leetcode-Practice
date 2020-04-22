package 剑指offer.week1.用两个栈实现队列;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目描述:
 *     请用栈实现一个队列，支持如下四种操作：
 *     push(x) – 将元素x插到队尾；
 *     pop() – 将队首的元素弹出，并返回该元素；
 *     peek() – 返回队首元素；
 *     empty() – 返回队列是否为空；
 * 注意：
 *     你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
 *     如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
 *     输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；
 */
class MyQueue {

    Stack<Integer> stack, cache;
    int size;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        cache = new Stack<>();
        size = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        //所有元素弹出到辅助栈
        while(!stack.empty()){
            cache.push(stack.pop());
        }
        //压入x
        stack.push(x);

        //所有元素压回到主栈
        while(!cache.empty()){
            stack.push(cache.pop());
        }

        size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack.empty()){
            return -1;
        }else {
            size--;
            return stack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(stack.empty()){
            return -1;
        }else {
            return stack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
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