package TEST;

/**
 * @author : dk
 * @date : 2019/9/2 14:07
 * @description :
 * 题目二：不修改数组找出重复的数字
 * 在一个长度为n+1的数组中的所有数字都在1～n的范围内，
 * 所以数组中至少有一个数字是重复的。
 * 在不修改输入数组的情况下找出数组中任意一个重复数字。
 * 例如输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，
 * 则对应输出的是2或者3
 */

public class Test1_1 {

    public static int getSmall(int a[])
    {
        if(a==null||a.length<1)
        {
            return -1;
        }
        int length =a.length;
        int bgein = 1;
        int end = length-1;
        while (end>=bgein)
        {
            int mid = ((end-bgein)>>1)+bgein ;
            int count = nums(a,bgein,mid);
            if (end == bgein)
            //当mid begin end三者重合时（区间内只有一个数字），判断出现次数是否大于1，
            {
                if (count>1)
                {
                    return bgein;
                }
                else
                {
                    break;
                }
            }
            if (count>(mid-bgein+1))
            //如果左边的数字出现的次数大于界限所有的数的数量
            {
                end=mid;
                //则将分界值作为右边界
            }
            else
            {
                bgein = mid+1;
                //否则将分界值后一个数作为左边界
            }
        }
        return -1;
    }

    private static int nums(int[] a, int bgein, int end) {
        if (a==null)
        {
            return 0;
        }
        int count = 0 ;
        for (int i = 0; i <a.length; i++)
        {
            if (a[i]>=bgein && a[i]<=end)
            {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a [] =new int []{2,2,3,1};
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"--");
        }
        System.out.println("");
        int small = getSmall(a);
        System.out.println(small);
    }
}
