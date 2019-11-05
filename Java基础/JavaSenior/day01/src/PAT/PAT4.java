package PAT;

/**
 * @author : dk
 * @date : 2019/10/2 10:58
 * @description :
 * nowcoder费了很大劲，终于和地外文明联系上。
 * 我们地球人通常有10根手指，因此我们习惯用10进制的数，而外星人的手指有16跟、8根等不等的数目，
 * 因此他们使用与我们不同的进制。
 * 为了方便沟通，需要你开发一款工具，把地球人的10进制转换成外星人的R进制形式。
 *
 * 对于每个用例，输出n对应的R进制形式。
 * 超过10进制的数，10用A表示、11用B表示，依次类推。
 */

public class PAT4
{

    public static void main(String[] args)
    {
//
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext())
//        {
//
//            System.out.println(Integer.toString(in.nextInt(), in.nextInt()).toUpperCase());
//
//        }
//        String a = "cccssSDSF";
//        System.out.println();

        long  n =Integer.MAX_VALUE;
        long  j = 0;
        int num = 0;
        int x =4;
//        for (long i = 2; i <24; i++)
//        {
//            j = i;
//            while (i!=1)
//            {
//                i = i/2 - 1;
//                num++;
//                if (i == 1&&num==x)
//                {
//                    System.out.println(j);
//                }
//                else if (i<=0)
//                {
//                    break;
//                }
//            }
//            num=0;
//        }
        for (int i = 10; i < 20; i++)
        {
//            j=i;
            i=i-1;
            System.out.println(i);
        }
    }
}

    /*
      public static String toString(int i, int radix)
      将 i  转换为  radix 进制返回,最高支持 36进制

    */