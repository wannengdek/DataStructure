package leetcode;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/18 08:07
 * @description :
 *
 *
 * 5
 *    1   4   5  16  17
 *    2   3   6  15  18
 *    9   8   7  14  19
 *   10  11  12  13  20
 *   25  24  23  22  21
 *
 */

public class Aaary
{
    public static void sout(int a[][])
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[0].length; j++)
            {
                System.out.printf("%4d",a[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int array[][] = new int[a][a];
        int p = 0;
        int index = 1;
        for (int i = 0; i < a; i++)
        {
            p = i;
            index = index + 2 * i;
            array[i][p] = index;
        }
       // 先赋值对角线的元素 然后根据对角线的规律给每个元素赋值
        for (int i = 1; i < a; i++)
        {
            int j = i;
            if (i%2==1)
            {
                int num = array[i][i];
                int num1 = array[i][i];
                int j2 = j;
                while (j2>=0)
                {
                    array[i][j2--]=num--;
                    // 10 11 12     13
                }
                while (j>=0)
                {
                    array[j--][i]=num1++;
                    //  16
                    //  15
                    //  14
                    //  13
                }
            }
            else
            {
                int number = array[i][i];
                int number1 = array[i][i];
                int m1=i,m2=i;
                int n=j;
                while (n>=0)
                {
                    array[n--][i]=number--;
                    //  5
                    //  6
                    //  7
                }
                while (j>=0)
                {
                    array[i][j--]=number1++;
                    //  9 8 7
                }
            }
        }
        sout(array);
    }
}
