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
     *
     *
     *
     *

     Arrays.fill(Object[ ] arr, Object obj);
     向数组中传送一个相同对象。
     Arrays.fill(int[ ] arr, int value);
     向数组中传送一个相同value。
     */
    public int Jump(int n)
    {
        int dp[] = new int[n+1];

        Arrays.fill(dp,1);

        return  dp[n-1];
    }

    /**
     *
     */
}
