package TEST;

/**
 * @author : dk
 * @date : 2019/9/19 21:18
 * @description :
 *
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */
public class Test16
{
    public double Power(double base, int exponent) {
        if (base<0||base==0)
        {
            return 0;
        }
        if (exponent==1)
        {
            return  base;
        }
        if (exponent<0)
        {
            exponent = -exponent;
        }
        boolean flag=false;//记录次方数是否为负数
        if(exponent<0)
        {
            flag=true;
            exponent=-exponent;//若为负数 则取绝对值后  计算取倒数
        }
        double temp = Power(base*base,exponent>>1);
        //如果exponent 为 偶数  那就是每次除2  得到偶数次方的结果  递归调用
        if (((exponent)&0x1)==1)
        //0x0和0x1分别表示十六进制的数的0和1
        //奇数的情况  余 1 所以在乘一次
        {
            temp=temp*base;
        }
        return flag ? 1/temp:temp;
    }
}
