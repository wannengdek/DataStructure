package TEST;

/**
 * @author : dk
 * @date : 2019/9/20 13:45
 * @description :
 * 打印从1 到最大的n位数
 * 输入数字n，按顺序打印1到最大的n位十进制数，
 * 输入3，打印1，2，3，，，，999.
 */
public class Test17
{
    public static void print1toN(int n)
    {
        if (n <= 0) return;
        String[] baseNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};//对应表
        int[] pointers = new int[n];//n位数字
        pointers[n - 1] = 1;
        boolean doneFlag = false;//判断输出完毕
        while (!doneFlag)
        {
            String currentNumber = "";
            for (int i = 0; i < n; i++)
            {//根据pointer得到输出字符串
                if (!(pointers[i] == 0 && currentNumber.equals("")))
                {
                    currentNumber = currentNumber + baseNum[pointers[i]];
                }
            }
            if (currentNumber.equals(""))
            {
                doneFlag = true;//数字归零，输出完毕
            }
            else
            {
                System.out.println(currentNumber);
            }
            pointMove(pointers, n);//字符串数字自增
        }
    }

    public static void pointMove(int[] pointers, int n)
    {
        int pointofPointers = n - 1;//指向数组末位
        while (pointofPointers >= 0)
        {
            pointers[pointofPointers]++;
            if (pointers[pointofPointers] >= 10)
            {
                pointers[pointofPointers] = 0;
                pointofPointers--;//进一
            }
            else
            {
                break;
            }
        }
    }

    public static void Print1ToMaxOfNDigits(int n)
    {
        // 健壮性判断
        if (n <= 0) throw new RuntimeException("n最小值为1");
        // 正式执行
        /*
        本题最需要注意的就是n过大时,long类型也不好使了,此时应该用char[]表示数字(大数问题), 打印string类型的数字
        关键在于如何用string表示数字? 如何知道已经打印到最大的数字? 毕竟不能作比较
         */
        char[] number = new char[n + 1]; //number[0]作为最大数字的进位标志位
        for (int i = 0; i < n + 1; i++)
            number[i] = '0';

        while (!increment(number))
        { // 没到最大值时,就不断循环打印
            PrintNumber(number);
        }
    }

    private static boolean increment(char[] number)
    {
        // 该函数执行数字加1的操作
        // 当前位的进位标志,也就是当前位是否有进位
        int jinWeiFlag = 0;
        // 一位一位的处理; 从个位开始
        for (int i = number.length - 1; i > 0; i--)
        {
            // nSum表示当前位是几
            // 除个位外的位,  其值等于原来的值(number[i] - '0')加上jinWeiFlag
            // 个位的值等于原来的值加1
            int nSum = number[i] - '0' + jinWeiFlag;
            if (i == number.length - 1) nSum++;
            // 接着判断当前位改变后是否能进位
            // 大于等于10则进位;否则不变
            // 有进位的时候要注意是谁有进位! 最高位有进位的话表示改变前已经达到最大值;
            if (nSum >= 10)
            {
                if (i == 1) // 如果最高位有进位
                    number[0] = '1'; // 这个值用于终止循环
                else
                { // 如果非最高位有进位
                    jinWeiFlag = 1;
                    number[i] = (char) (nSum - 10 + 48); // +48是为了转换成char类型的数字
                }
            }
            else
            {
                // jinWeiFlag由当前位值的决定,影响的是下一位取值
                jinWeiFlag = 0; // 清除进位状态, 下面将会根据改变后的值重新判断jinWerFlag的取值
                number[i] = (char) (nSum + 48);
            }

        }
        return number[0] == '1';
    }

    private static void PrintNumber(char[] number)
    {
        //从第一个非零数字开始打印!
        boolean flag = true; // 当前位还是0则为ture
        for (int i = 1; i < number.length; i++)
        {
            if (flag && number[i] != '0') flag = false;
            if (!flag && i == number.length - 1)
            {
                System.out.println(number[i]);
                break;
            }
            if (!flag) System.out.print(number[i]);
        }
    }


    public static void main(String[] args)
    {
    }
}
