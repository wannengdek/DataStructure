package TEST;

/**
 * @author : dk
 * @date : 2019/9/18 21:48
 * @description :
 * <p>
 * 给你一根长度为n的绳子，
 * 请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 */

public class Test14
{
    public int cutRope(int target)
    {
        if (target < 2)
        {
            return 0;
        }
        if (target == 2)
        {
            return 1;
        }
        if (target == 3)
        {
            return 2;
        }
        int a[] = new int[target + 1];
        a[0]=0;
        a[1]=1;
        a[2]=2;
        a[3]=3;
        int max = 0;
        for (int i = 4; i <=target; i++)
        {
            max = 0;
            for (int j = 1; j < i/2; j++)
            {
                int temp = a[j] * a[i - j];
                if (temp > max)
                {
                    max = temp;
                }
                a[i] = max;
            }
        }
        //两层循环
        max = a[target];
        return max;
    }
    public int cutRope1(int target)
    {
        if (target < 2)
        {
            return 0;
        }
        if (target == 2)
        {
            return 1;
        }
        if (target == 3)
        {
            return 2;
        }
        int max = 0;
        int threeTime = target/3;
        target = target-3*threeTime;
        if (target==1)
        {
            threeTime -=1;
            // 对于 最后一段  4米的长度   2*2  要大于3*1   也就是如果刚好剩下1米时，要将上一步减去的3m加回来
        }
        int
        return max;
    }
}
