package TEST;

/**
 * @author : dk
 * @date : 2019/9/4 22:28
 * @description :
 * 斐波那契数列
 */

public class Test10_1
{
    /**
     * 直接递归
     * @param n
     * @return
     */
    public static int fei(int n)
    {
        if (n<=1)
        {
            return n;
        }
        return fei(n-1)+fei(n-2);
    }

    /**
     * 使用累加的方式,算后面的数
     */
    public static int fei2(int n)
    {
        if(n<=1)
        {
            return n;
        }
        int pre1=1;//前一项为1
        int pre2=0;//前两项为0
        int fibN=0;
        for(int i=2;i<=n;i++)
        {
            fibN=pre1+pre2;
            pre2=pre1;//前进一位
            pre1=fibN;
        }
        return fibN;

    }
    public static void main(String[] args)
    {
        System.out.println(fei(2));
    }
}
