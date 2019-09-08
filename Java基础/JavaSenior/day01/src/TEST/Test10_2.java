package TEST;

import java.util.Arrays;

/**
 * @author : dk
 * @date : 2019/9/7 20:48
 * @description :
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 */

public class Test10_2
{
    /**
     *  当上第三级阶梯是
     *
     *  f 3 = f 2  + f 1 + f 0
     *        f 2  = f  1 + f 0
     *               f  1 =  f 0
     * 双层循环   外循环为 上楼梯的节数
     * 内循环为 从 第 0 级上到 第 i 级的阶梯的跳法
     Arrays.fill(Object[ ] arr, Object obj);
     向数组中传送一个相同对象。
     Arrays.fill(int[ ] arr, int value);
     向数组中传送一个相同value。
     */
    public static int Jump(int n)
    {
        int dp[] = new int[n+1];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++)
        //从第一级阶梯往上遍历
        {
            for(int j=0;j<i;j++)
            // 第 i 级 楼梯前   是   i  种走法
                //  比如 第 2 级楼体    f(2) = f(1) + f(0)
            {
                dp[i]=dp[i]+dp[j];
            }
        }
        return  dp[n-1];
    }

    /**
     * 由上面的思路 要跳上第n级台阶
     * 有：f(n) = f(n-1) + f(n-2) + ... + f(0)
     * 要跳上第n-1级台阶
     * 有：f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * 两式相减 得：
     * f(n)-f(n-1)=f(n-1)
     * 即：
     * f(n)=2*f(n-1)
     * 即
     * f(n)=2^(n-1)
     */
    public int JumpFloor(int target)
    {
        return (int)Math.pow(2, target-1);
    }

    public static void main(String[] args)
    {
        Jump(2);
    }
}
