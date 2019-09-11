package TEST;

/**
 * @author : dk
 * @date : 2019/9/8 20:28
 * @description :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

public class Test11
{
    public int minNumberInRotateArray(int[] array)
    {
        if (array.length == 1)
        {
            return 0;
        }
        int index1 = 0;
        //如果只旋转了 0 个数字  且 则第一个数字为整个数组中最小的
        int index2 = array.length - 1;
        int mid = 0;
        while (array[index1] >= array[index2])
        {
            if (index2 - index1 == 1)
            //当 第二个指针和第一个指针相差 1  时, 指针2 指向的数就是要找的数
            // 此时  第一个指针指向了 较大数组中的最后一个数
            {
                mid = index2;
                break;
            }

            /**
             * 考虑特殊情况
             *
             * 0 1 1 1 1 的旋转  1 0 1 1 1
             *
             * 按照 未修改的办法解决肯定是错的
             * 此时只能按顺序去寻找 数组中最小的数
             *
             */
            if (array[index1]==array[index2]&&array[index1]==array[mid])
            {
                mid = find(array);
                return mid;
            }
            mid = (index1 + index2) >> 1;
            if (array[mid] >= array[index1])
            //  整个数组中间的数 大于  第一个数   那中间的数还在前面的数组中
            // 修改指针  将第一个指针 指向 当前中间的数
            {
                index1 = mid;
            }
            else if (array[mid] <= array[index2])
            //整个数组中间的数    小于  最后一个数   那中间的数还在后面较小的数组中
            //修改 指针    将第二个指针指向 当前中间的数
            {
                index2 = mid;
            }
        } return array[mid];
    }

    public static int find(int[] array)
    {
        int min = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                min = i + 1;
            }
        }

        return array[min];
    }


}
