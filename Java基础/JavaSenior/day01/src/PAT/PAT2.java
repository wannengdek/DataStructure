package PAT;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/1 22:20
 * @description :
 *
童年生活二三事

时间限制 1000 ms 内存限制 32768 KB 代码长度限制 100 KB 判断程序 Standard (来自 小小)
题目描述

NowCoder小时候走路喜欢蹦蹦跳跳，他最喜欢在楼梯上跳来跳去。
但年幼的他一次只能走上一阶或者一下子蹦上两阶。
现在一共有N阶台阶，请你计算一下NowCoder从第0阶到第N阶共有几种走法。
 */

public class PAT2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long[] a = new long[92];
        //后面的数会很大,所以得用long 来存

        a[1] = 1;
        a[2] = 2;

        for (int i = 3; i < a.length; i++)
            a[i] = a[i - 1] + a[i - 2];
        while (sc.hasNext())
        {
            int c = sc.nextInt();
            System.out.println(a[c]);
        }
    }
}
