package leetcode;

/**
 * @author : dk
 * @date : 2019/11/4 21:13
 * @description :
 */

public class ArraysXZhi
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }

    private static void printMatrixZigZag(int[][] matrix)
    {
        int row = 0;
        int col = 0;
        int row1 = matrix.length - 1;
        int col1 = matrix[0].length - 1;
        boolean f = true;
        while (row != row1 && col != col1)
        {
            sout(row, row1, col, col1, f, matrix);

            f=!f;
        }
    }

    private static void sout(int row, int row1, int col, int col1, boolean f, int[][] matrix)
    {
        if (f == true)
        {
            while (row!=row1)
            {
                System.out.print(matrix[row1--][col1--]+" ");
            }
        }
        else
        {
            while (col1!=col)
            {
                System.out.print(matrix[row1++][col--]+" ");
            }
        }
    }
}
