package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/31 16:07
 * @description :
 */

public class Tess
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a =0;

        double b[] =new double [1000];

        a = sc.nextInt();

        for (int i = 0; i < a; i++) {
            b[i]=sc.nextDouble();
        }
        int number = sc.nextInt();

        double money = sc.nextDouble();

        Arrays.sort(b);

        System.out.println(number+" "+money);

        for (int i = 0; i < a; i++) {
            System.out.println(b[i]);
        }

        System.out.println(1111);

    }
}
