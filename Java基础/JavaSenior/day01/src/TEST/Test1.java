package TEST;



/**
 * @author : dk
 * @date : 2019/9/2 14:20
 * @description :
 * 题意:
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。
 * 数组中某些数字是重复的，但是不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，
 * 如果输入长度为7的数组为{2，3，1，0，2，5，3}，
 * 那么对于的输出是重复的数字2或者3。
 */

public class Test1 {
    public static void swap(int arr[],int a,int b)
    {
        int temp = arr[a];
        arr[a]= arr [b];
        arr [b] = temp ;
    }
    public static int getSmall(int [] arr)
    {
        if (arr.length<0||arr.length<2)
        {
            return -1;
        }
        int n = arr.length;
        int i=0;
        while (i<n)
        {
            if (arr[i]==i)
            {
                i++;
            }
            else if (arr[i]!=i)
            {
                if (arr[arr[i]]==arr[i])
                {
                    return arr[i];
                }
                swap(arr,arr[i],i);
                i++;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int a [] =new int []{0,1};
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"--");
        }
        System.out.println("");
//        swap(a,1,2);
        int small = getSmall(a);
        System.out.println(small);

        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"--");
        }
    }
}
