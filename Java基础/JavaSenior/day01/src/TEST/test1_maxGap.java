package TEST;

/**
 * @author : dk
 * @date : 2019/9/1 16:34
 * @description :
 * ### **求最大差值**
 *
 * 一个数组，无序，如果排序之后相邻两数的最大差值时多少？
 * （如果数组是Long 类型）时间复杂度为O（n）。
 *
 * 例子：  0 99 66 2
 *
 * 排序后 0 2 66 99
 *
 * 最大差值为  66-2=64
 *
 * 假设这个数组里有 2^63-1 个数呢？
 */

public class test1_maxGap {
    public static int maxGap(int [] nums)
    {
        if (nums==null||nums.length<2)
        {
            return  0;
        }
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
        int len = nums.length;
        for (int i = 0 ;i<nums.length ;i++)
        {
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        boolean [] hasNum = new boolean[len+1];
        int [] maxs = new int[ len+1];
        int [] mins = new int[len+1];

        int bid= 0;
        for (int i = 0; i <nums.length ; i++) {
            bid = bucket(nums[i],len,min,max);
            mins[bid] = hasNum[bid]? Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true ;
        }
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i <=len ; i++) {
            if (hasNum[i])
            {
                res = Math.max(res,mins[i]);
                lastMax = maxs[i];
            }
        }
        return  res;
    }
    private static int bucket(long num, long len, long min, long max) {
        return (int)((num-min)*len/(max-min)) ;
    }
}
