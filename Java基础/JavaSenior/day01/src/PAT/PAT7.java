package PAT;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/2 13:18
 * @description :
 * NowCoder号称自己已经记住了1-100000之间所有的斐波那契数。
 * 为了考验他，我们随便出一个数n，
 * 让他说出第n个斐波那契数。
 * 当然，斐波那契数会很大。
 * 因此，如果第n个斐波那契数不到6位，则说出该数；否则只说出最后6位。
 */

public class PAT7
{

//先计算出所有的斐波那契数     然后再进行判断.
    static long[] fib = new long[100001];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        fib[1]=1;
        fib[2]=2;
        long num =0;
        for (int i = 3; i <100001; i++)
        {
            fib[i] =(fib[i-1]+fib[i-2])%1000000;
        }
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            //   System.out.println(fib[n]);
            System.out.printf(n<25?"%d\n":"%06d\n",fib[n]);
            //会有第6位是0的情况,按正常输出就会出错,所以要修改为%06d
            //输出一个十进制的数，占六位，若不够六位则在这个数的前面补零

        }

    }
}
