package leetcode;

import java.util.Arrays;

/**
 * @author : dk
 * @date : 2019/11/5 11:35
 * @description :
 */

public class Sort
{
    public static void main(String[] args) {
        int[] arr={1,2,3};
        nextPer(arr,0);
    }
    private static void nextPer(int[] arr,int start){
        //当start==arr.length-1时，说明子序列的长度为1，就不用再往下分子序列了
        if(start==arr.length-1){
            System.out.println(Arrays.toString(arr));
        }
        for(int i=start;i<arr.length;i++){
            //start代表的是每一个子序列的第一个位置，我们每一层递归的任务都只有一个：
            //枚举该层子序列第一个位置可以取的值
            int temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
            //该层递归的子序列第一个位置已经确定了，所以又可以往下再分
            nextPer(arr,start+1);
            //把第该层子序列第一个位置的值换成另外一个值，所以要交换回来
            temp=arr[start];
            arr[start]=arr[i];
            arr[i]=temp;
        }
    }
}
