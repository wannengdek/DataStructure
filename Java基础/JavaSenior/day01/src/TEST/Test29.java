package TEST;

import java.util.ArrayList;

/**
 * @author : dk
 * @date : 2019/9/29 13:57
 * @description :
 * 顺时针打印矩阵
 */

public class Test29
{
    ArrayList arrayList = new ArrayList();
    public ArrayList<Integer> printMatrix(int[][] matrix)
    {
        int row1 = 0;
        int  cow1= 0;
        int row2 = matrix.length - 1;
        int  cow2= matrix[0].length - 1;
        while (cow1 <= cow2 && row1 <= row2) {
            printEdge1(matrix, row1++, cow1++, row2--, cow2--);
        }
        return arrayList;
    }
    public  void printEdge1(int[][] m, int row1, int cow1, int row2, int cow2)
    {
        if(row1==row2)
        {
            for (int i = cow1; i <= cow2; i++)
            {
                arrayList.add(m[row1][i]);
                //只有一行， 遍历每列
            }
        }
        else if (cow1==cow2)
        {
            for (int i = row1; i <= row2; i++)
            {
                arrayList.add(m[i][cow1]);
                //只有一列  遍历每行
            }
        }
        else
        {
            int c=cow1;
            int r=row1;
            while(c!=cow2)
            {
                arrayList.add(m[row1][c]);
                // 左到右
                c++;
            }
            while(r!=row2)
            {
                arrayList.add(m[r][cow2]);
                //上到下
                r++;
            }
            while(c!=cow1)
            {
                arrayList.add(m[row2][c]);
                // 右到左
                c--;
            }
            while(r!=row1)
            {
                arrayList.add(m[r][cow1]);
                // 下到上
                r--;
            }
        }
    }

}
