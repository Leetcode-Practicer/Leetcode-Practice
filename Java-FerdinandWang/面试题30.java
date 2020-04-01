/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题30 包含min函数的栈
 * 题目链接:https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
*/

//本题的思路主要是利用双栈
import java.util.Stack;
class MinStack {
    Stack<Integer> data;   //数据栈
    Stack<Integer> helper; //辅助栈
    /** initialize your data structure here. */
    public MinStack() {    //初始化栈
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }
    
    //压栈
    //数据栈压入数据，
    //判断，如果辅助栈为空或者辅助栈顶数据大于等于数据，则压入辅助栈，否则辅助栈压入原栈顶数据
    //这样可以保证辅助栈顶始终是最小值
    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || helper.peek() >= x){
            helper.push(x);
        }else{
            helper.push(helper.peek());
        }
    }
    
    //弹栈，双栈同时弹出数据
    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            helper.pop();
        }
        
    }
    
    //查看栈顶数据
    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈为空，此操作非法");
    }
    
    //最小值即为辅助栈栈顶数据
    public int min() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈为空，此操作非法");
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */