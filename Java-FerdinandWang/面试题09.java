/**
 * 本题目为Leetcode-cn.com
 * 剑指Offer专栏
 * 面试题09 用两个栈实现队列
 * 题目链接:https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 
 * 
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
class CQueue {

    //栈1用于存储数据
    Stack<Integer> stack1;
    //栈2用于辅助
    Stack<Integer> stack2;

    //队列容量
    int size;

    //构造函数初始化
    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    
    //添加值到尾部
    public void appendTail(int value) {
        
        //将栈1中的值逐个弹出并压入到栈2中
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        //将待添加值压入栈1中
        stack1.push(value);

        //将栈2中的值逐个弹出压回到栈1中
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        //维护队列容量
        size++;
        
    }
    
    //删除头部元素的值
    public int deleteHead() {
        //如果队列为空则返回-1
        if(size == 0){
            return -1;
        }else{//维护队列容量，直接从栈1弹出元素（也就是队列的头部元素）
            size--;
            return stack1.pop();
        }
    }
}

