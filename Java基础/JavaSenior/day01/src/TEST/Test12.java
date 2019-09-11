package TEST;

/**
 * @author : dk
 * @date : 2019/9/10 13:55
 * @description :
 */

public class Test12
{

    public static void main(String[] args)
    {
        char c[] = new char[]{};
        char a[]= new char[]{'b','f','c','e'};
        char b[][] = new char[][]{{'a','b','t','g'},
                                  {'c','f','c','s'},
                                  {'j','d','e','h'}
                                  };
        //hasPath(c,b.length-1,b[0].length-1,a);
    }
    private int rows;
    private int cols;//记录矩阵的规格
    public boolean hasPath(char[] array, int rows, int cols, char[] str)
    {
        if(array==null||rows<1||cols<1||str==null)
        {
            return false;
        }
        this.rows=rows;
        this.cols=cols;
        boolean visit[][]=new boolean[rows][cols];
        char matrix[][]=new char[rows][cols];
        int rebuildindex=0;
        // 将题目中给出的矩阵  还原为二维矩阵,方便接下来的查找
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                matrix[i][j]=array[rebuildindex++];
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(hasPathCore(matrix,str,visit,0,i,j))//从每个位置开始尝试
                {
                    return true;
                }
            }
        }

        return false;
    }

    public  boolean hasPathCore(char[][] matrix, char[] str, boolean[][] visit, int pathLen, int rownow, int colnow)
    {
        if (str.length==pathLen)
        {
            return true;
        }
        //当str 的长度与 pathlen 的长度一致时,就是每个str 都找到了对应的位置
        if (rownow>0||rownow>=rows||colnow<0||colnow>=cols)
        {

        }
        return false;
    }
}
