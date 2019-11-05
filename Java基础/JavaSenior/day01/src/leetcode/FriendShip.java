package leetcode;

import java.util.Scanner;

/**
 * @author : dk
 * @date : 2019/10/31 16:58
 * @description :
 *
 */

public class FriendShip
{
    public static void main(String[] args)
    {
        int array[][]=new int [1000][2];
        int i=0,j=0;
        Scanner sc = new Scanner(System.in);
        int num=0;
        //记录次数
        while (!sc.hasNext("-1"))
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            array[i][0]=a;
            array[i][1]=b;
            i++;
            num++;
        }
        for (int k = 0; k <num; k++)
        {
            System.out.println(array[k][0]+" "+array[k][1]);
        }

        int n =sc.nextInt();
        int m = sc.nextInt();
        int temp = 0;
        boolean flag = true;
        find(n,m,array,num,n,flag);
    }

    private static void find(int n, int m, int[][] array, int num, int temp,boolean f)
    {
        if (f==true)
        {
            for (int k = 0; k < num; k++)
            {
                if (array[k][0]==temp)
                {
                    temp = array[k][1];
                    if (temp==m)
                    {
                        System.out.println("yes");
                        return;
                    }
                    else
                    {
                        f =!f;
                        find(n,m,array,num,temp,f);
                    }
                }
                if (k==num-1&&array[k][1]!=m)
                {
                    System.out.println("No");
                    return;
                }
            }
        }
        else
        {
            for (int k = 0; k < num; k++)
            {
                if (array[k][0]==temp)
                {
                    temp = array[k][1];
                    if (temp==m)
                    {
                        System.out.println("yes");
                        return;
                    }
                    else
                    {
                        f =!f;
                        find(n,m,array,num,temp,f);
                    }
                }
                if (k==num-1&&array[0][k]!=m)
                {
                    System.out.println("No");
                    return;
                }
            }
            f = true;
            find(n,m,array,num,temp,f);
        }
    }
}
