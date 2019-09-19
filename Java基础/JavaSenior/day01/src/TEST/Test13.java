package TEST;

/**
 * @author : dk
 * @date : 2019/9/11 19:02
 * @description :
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，
 * \每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */

public class Test13
{
    public static void main(String[] args)
    {
        System.out.println(movingCount(15, 20, 20));
    }

    public static int movingCount(int threshold, int rows, int cols)
    {
        if (threshold<0||rows<0||cols<0)
        {
            return 0;
        }
        int a[][] = new int[rows][cols];

        return movingCountNumber(a,0,0,rows,cols,threshold);

    }

    public static int movingCountNumber(int[][] a, int rownow, int colnow, int rows, int cols, int threshold)
    {
        if (threshold<=0||rownow>=rows || colnow>=cols ||rownow<0 || colnow<0
       ||   (a[rownow][colnow] == 1) || getNum(colnow)+getNum(rownow) > threshold
        )
        {
            return 0 ;
        }
        a[rownow][colnow] =1;
        return  movingCountNumber(a,rownow+1,colnow,rows,cols,threshold)+
                movingCountNumber(a,rownow-1,colnow,rows,cols,threshold)+
                movingCountNumber(a,rownow,colnow+1,rows,cols,threshold)+
                movingCountNumber(a,rownow,colnow-1,rows,cols,threshold)+1 ;
    }



    public static int  getNum(int n)
    {
        //return  rownow%10 + rownow/10;
        //只适合两位数的情况
        int num=0;
        while (n>0)
        {
            num=num+n%10;
            n=n/10;
        }
        return num;
    }



}
