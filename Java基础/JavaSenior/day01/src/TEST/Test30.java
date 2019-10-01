package TEST;

import java.util.Stack;

/**
 * @author : dk
 * @date : 2019/9/29 17:01
 * @description :
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Test30
{
    private Stack<Integer> dataStack=new Stack<>();
    private Stack<Integer> helpStack=new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (helpStack.isEmpty())
            helpStack.push(node);
        else
            helpStack.push(Math.min(node,helpStack.peek()));
    }
    public void pop() {
        dataStack.pop();
        helpStack.pop();
    }
    public int top() {
        return dataStack.peek();
    }
    public int min() {
        return helpStack.peek();
    }
}
