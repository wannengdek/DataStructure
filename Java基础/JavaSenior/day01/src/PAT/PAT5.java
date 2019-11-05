package PAT;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/2 12:39
 * @description :
 * 在2×n的一个长方形方格中,用一个1× 2的骨牌铺满方格,输入n ,输出铺放方案的总数.
 *
 * 例如n=3时,为2× 3方格，骨牌的铺放方案有三种
 *
 * http://uploadfiles.nowcoder.com/images/20141114/51_1415949553292_1(1).jpg
 *
 *
 */

public class PAT5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext())
        {
            int n = sc.nextInt();
            if (n<=2) System.out.println(n);
            else
            {
                int first=1;
                int second=2;
                int num =0;
                for (int i = 3; i <=n; i++)
                {
                    num = first+second;
                    first = second;
                    second =num;
                }
                System.out.println(num);
            }
        }
    }
}
