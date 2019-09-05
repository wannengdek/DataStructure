package homework;

/**
 * @author : dk
 * @date : 2019/9/5 14:55
 * @description :
 */

public class Test
{
    public static int total = 0;

    public static void swap(String[] str, int i, int j)
    {
        String temp = new String();
        temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void arrange(String[] str, int st, int len)
    {
        if (st == len - 1)
        {
            for (int i = 0; i < len; i++)
            {
//                    System.out.print(str[i]+ "  ");
            }
//                System.out.println();
            total++;
        }
        else
        {
            for (int i = st; i < len; i++)
            {
                swap(str, st, i);
                arrange(str, st + 1, len);
                swap(str, st, i);
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
           /* String str[] = {"1","2","3","4","5"};
            arrange(str, 0, str.length);
            System.out.println(total);
*/
        int[] a = new int[]{1, 2, 3, 5, 7};
        int[] b = new int[]{1, 2, 3, 5, 7};
        int[] c = new int[15];

//        shuchu(a,b,c);
    }



}
