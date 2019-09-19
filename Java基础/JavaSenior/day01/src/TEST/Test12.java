package TEST;

/**
 * @author : dk
 * @date : 2019/9/10 13:55
 * @description :
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */

public class Test12
{
    private int rows;
    private int cols;
    //记录矩阵的规格
    public boolean hasPath(char[] array, int rows, int cols, char[] str)
    {
        if (array == null || rows < 1 || cols < 1 || str == null)
        {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean visit[][] = new boolean[rows][cols];
        char matrix[][] = new char[rows][cols];

        int rebuildindex = 0;
        // 将题目中给出的矩阵  还原为二维矩阵,方便接下来的查找
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                matrix[i][j] = array[rebuildindex++];
            }
        }
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (hasPathCore(matrix, str, visit, 0, i, j))
                    //从每个位置开始尝试
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasPathCore(char[][] matrix, char[] str, boolean[][] visit, int pathLen, int rownow, int colnow)
    {
        if (str.length == pathLen)
        //当str 的长度与 pathlen 的长度一致时,就是每个str 都找到了对应的位置
        {
            return true;
        }
        if (rownow < 0 || rownow >= rows || colnow < 0 || colnow >= cols
                || matrix[rownow][colnow]!=str[pathLen] || visit[rownow][colnow]
        )
        {
            return false;
        }
        visit[rownow][colnow] = true;
        if (hasPathCore(matrix,str,visit,pathLen+1,rownow-1,colnow) //上
    || hasPathCore(matrix,str,visit,pathLen+1,rownow+1,colnow) //下
    ||hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow-1) // 左
    ||hasPathCore(matrix,str,visit,pathLen+1,rownow,colnow+1) //右
        )
        {
            return true;
        }
        visit[rownow][colnow] = false;
        return false;
    }
}
