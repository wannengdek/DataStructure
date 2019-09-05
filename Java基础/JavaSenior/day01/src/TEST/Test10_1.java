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
        int num = 0;
        int a[] = new int[]{1,1};

        for (int i = 0; i <n; i++)
        {
            num = 1;
        }
        return num;
    }
    public static void main(String[] args)
    {
        System.out.println(fei(2));
    }
}
