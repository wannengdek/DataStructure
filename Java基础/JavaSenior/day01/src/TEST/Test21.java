package TEST;

/**
 * @author : dk
 * @date : 2019/9/24 23:06
 * @description :
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Test21
{
    public void reOrderArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] % 2 == 0 && array[j + 1] % 2 != 0)
                {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
    }

    public void reOrderArray1(int[] array)
    {
        int num = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] % 2 == 1)
            {
                num++;
            }
        }
        int[] copy = array.clone();
        //克隆数组
        int a = 0;
        //分开计算位置   如果只用i 会出现重复赋值
        for (int i = 0; i < copy.length; i++)
        {
            if (copy[i] % 2 == 1)
            //奇
            {
                array[a++] = copy[i];
            }
            else
            {
                array[num] = copy[i];
                num++;
            }
        }
    }


    public void reOrderArray3(int[] array)
    {
        //相对位置不变，稳定性
        //插入排序的思想
        int m = array.length;
        int k = 0;//记录已经摆好位置的奇数的个数
        for (int i = 0; i < m; i++)
        {
            if (array[i] % 2 == 1)
            {
                int j = i;
                while (j > k)
                {//j >= k+1
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                    j--;
                }
                k++;
            }
        }
    }
}
