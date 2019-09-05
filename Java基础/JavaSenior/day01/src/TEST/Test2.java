package TEST;

/**
 * @author : dk
 * @date : 2019/9/2 16:57
 * @description :
 *
 * 题目：在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，
 * 输入这样一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */

public class Test2 {
    public static boolean Find(int target, int[][] array) {
        if(array.length==0||array[0].length==0||array==null)
        {
            return false;
        }
        int row = array.length;
        int rows = 0 ;
        int col = array[0].length;
        int cols = col-1;
        while (cols>=0&&rows<=row-1)
        {
            if (array[rows][cols]==target)
            {
                return true;
            }
            else if (array[rows][cols]>target)
            {
                cols--;
            }
            else
            {
                rows++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,8,9},{4,7,10,13}};
        int b = 7;
        System.out.println(Find(b,a));
    }

    private static boolean getNum(int[][] a, int b) {
        int row = a.length-1;
        int col = a[0].length-1;
        return  getNumexist(a,row,col,b);
    }

    private static boolean getNumexist(int[][] a, int row, int col, int b) {
        while (col>=0)
        {
            if (a[0][col]==b)
            {
                return true;
            }
            if (a[0][col]<b)
            {
                for (int i = 0; i < row; i++)
                {
                    if(a[i][col]==b)
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            if (a[0][col]>b)
            {
                col--;
            }
        }
       return false;
    }
}
