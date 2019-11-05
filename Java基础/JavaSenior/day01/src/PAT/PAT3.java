package PAT;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/1 23:13
 * @description :
 * 对于表达式n^2+n+41，当n在（x,y）范围内取整数值时（包括x,y）(-39<=x<50),
 * 判定该表达式的值是否为素数
 */

public class PAT3
{
//    public static int sushu(int n)
//    {
//        if(n<2) return 0;
//        if(n == 2) return 1;
//        if(n%2 == 0) return 0;
//        for (int i = 2; i < Math.sqrt(n); i++)
//        {
//            if (n%i==0)
//                return 0;
//            //提前返回   不是素数
//        }
//        return 1;
//        //是素数
//    }
    public static boolean flag(int start,int end)
    {
        int temp =0;
        for (int i = start; i <=end ; i++)
        {
            temp = (int)(Math.pow(i, 2) + i + 41);
            for(int j = 2;j <= Math.sqrt(temp);j++) {
                if(temp % j == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int start =40;
        int end =40;
        while (scanner.hasNext())
        {
            start = scanner.nextInt();
            end = scanner.nextInt();
            if (start==0&&end==0)
                break;
            boolean a =flag(start,end);

            if (a)
                System.out.println("OK");
            else
                System.out.println("Sorry");
        }
    }
//    public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int m = scanner.nextInt();
//    int n = scanner.nextInt();
//    while (!(m == 0 && n == 0)) {
//        if (funSuShu(m, n)) {
//            System.out.println("OK");
//        } else {
//            System.out.println("Sorry");
//        }
//        m = scanner.nextInt();
//        n = scanner.nextInt();
//    }
//    scanner.close();
//}
//    private static boolean funSuShu(int m, int n) {
//        int temp = 0;
//        for(int i = m;i <= n;i++) {
//            temp = (int)(Math.pow(i, 2) + i + 41);
//            for(int j = 2;j <= Math.sqrt(temp);j++) {
//                if(temp % j == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
