package TEST;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : dk
 * @date : 2019/9/9 18:53
 * @description :
 *
 */

public class Test19
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int cow = scanner.nextInt();
        int number = (int)( Math.pow(2,cow)-1);
        int a[] = new int[number+1];
        for (int i = 0; i <a.length-1 ; i++)
        {
            a[i]=scanner.nextInt();
        }
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();


//        9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
        int i = find(cow, a, number, num1, num2);
        System.out.println(i);
//        Scanner scanner = new Scanner(System.in);
//        int c=scanner.nextInt();
//        int n = (int) (Math.pow(2, c)-1);
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//        for(int i=0;i<n;i++) {
//            int t = scanner.nextInt();
//            map.put(t, i);
//        }
//        int a = scanner.nextInt();
//        a = map.get(a);
//        int b = scanner.nextInt();
//        b = map.get(b);
//        for(;;) {
//            if(a==b) {
//                System.out.println(map.get(a));
//                break;
//            }
//            if(a>b) {
//                b = b/2-1;
//            }
//            if(a<b) {
//                a = a/2-1;
//            }
//        }

    }
    public static int find(int cow, int[] a, int number,int num1,int num2)
    {
        if (num1==num2)
        {
            return -2;
        }
        Set<Integer> set =new HashSet<>();
        int n1 =mid(num1);
        int n2 =mid(num2);
        if (n1==n2)
        {
            return a[n1];
        }
        while (n1==n2)
        {
            if (mid(n1)<n2)
            {
                if (mid(n2)>=0)
                {
                    n2 = mid(n2);
                }
            }
            else if (mid(n1)>n2)
            {
                if (mid(n1)>=0)
                {
                    n1 = mid(n1);
                }
            }
        }
        return a[n1];
    }
    public static  int mid(int a)
    {
        return (int)((a-1)>>1);
    }
}
