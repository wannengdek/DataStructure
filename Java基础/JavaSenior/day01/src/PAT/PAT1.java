package PAT;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/1 22:54
 * @description :
 * 链接：https://www.nowcoder.com/questionTerminal/d948f2f33a5f49bc800c5a85fe001d9a
 * 来源：牛客网
 * <p>
 * <p>
 * 有一头母牛，它每年年初生一头小母牛。每头小母牛从第四个年头开始，每年年初也生一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 */

public class PAT1
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[56];
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        for (int i = 4; i < a.length; i++)
            a[i] = a[i - 1] + a[i - 3];
        while (sc.hasNext())
        {
            int c = sc.nextInt();
            System.out.println(a[c]);
           /*
           https://blog.csdn.net/yangxue_mifen/article/details/78336203
             Scanner sc = new Scanner(System.in);
            此句 表示从控制台获取数据，
            sc.hasNext() 表示你是否有输入数据，
            while语句块 表示当你输入数据的时候，就执行输出sc.next()（输出内容）
            所以只要你输入数据了，它就可以执行，
            所以后台只是开了一块内存，一直未关闭，不算死循环
            2hasNext()这个方法是如果此扫描器的输入中有另一个标记，则返回 true。
            在等待要扫描的输入时，此方法可能阻塞。扫描器将不执行任何输入。所以循环会一直下去。
            你可以设置一个终止符，调用hasNext()的重载方法hasNext(String patten)：
            *如果下一个标记与从指定字符串构造的模式匹配，则返回 true。扫描器不执行任何输入。
            例：以输入"0"，结束输出
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNext("0")) {
            System.out.println(sc.next());
           */
        }
    }
}
