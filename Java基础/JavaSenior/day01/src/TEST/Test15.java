package TEST;

/**
 * @author : dk
 * @date : 2019/9/19 08:19
 * @description :
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */


public class Test15
{
    public int NumberOf1(int n) {
        int count = 0;
        long flag =1;
        while (flag!=0)
        {
            if( (n&flag)!=0)
            {
                count++;
            }
            flag =flag<<1;
        }
        return count;
    }
//    public int NumberOf1(int n) {
//        int count =0;
//        while (n!=0)
//        {
//            count++;
//            n=(n-1)&n;
//        }
//        return count;
//    }
}
