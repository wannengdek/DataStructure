package TEST;

import java.util.Stack;

/**
 * @author : dk
 * @date : 2019/9/29 19:20
 * @description :
 *输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

public class Test31
{
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length==0||popA.length==0)
            return  false;
        Stack<Integer> dataStack = new Stack<>();
        int popIndex = 0;
        //记录出栈位置
        for (int i = 0; i < pushA.length; i++)
        {
            dataStack.push(pushA[i]);
            while (!dataStack.empty()&&dataStack.peek()==popA[popIndex])
            //先判断是否为空  再判断 栈顶元素与出栈数组中的元素是否相同
            {
                dataStack.pop();
                popIndex++;
                //相同出栈
            }
        }
        return dataStack.empty();
        //如果栈内为空,那就是出栈完毕,即按照出栈数组中顺序可以出栈完毕  那么出栈数组就是正确的序列
    }
}
