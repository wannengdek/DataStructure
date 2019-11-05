package leetcode.贪心;

/**
 * @author : dk
 * @date : 2019/10/18 08:56
 * @description :
 */

public class Test1
{
    public static void fun(int num[],int k)
    {
        int res=0;
        int n = num.length-1;
        int number = 0;
        for (int i = n; i >=0 ; i--)
        {
            number =Math.min(k/money[i],num[i]);
            k=k-number*money[i];
            res+=number;
        }
        if (k>0) System.out.println("钱不够");
        else if (k<-1) System.out.println("钱够花,花了"+res+"张");
        else if (k==0) System.out.println("钱刚好花完,花了"+res+"张");
    }
    public static int money[]={1,2,5,10,20,50,100};
    public static void main(String[] args)
    {
//        Scanner scanner = new Scanner(System.in);
//        int num[]= new int [7];
//        for (int i = 0; i < 7; i++)
//        {
//            num[i]=scanner.nextInt();
//        }
////        for (int i = 0; i <7; i++)
////        {
////            System.out.println(num[i]);
////        }
//        int k =scanner.nextInt();
//        fun(num,k);
        String s ="" ;

//        System.out.println(fun(7, 2));

        int n = 18;
//        Integer.toHexString(n);
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(Integer.toString(100, 7));

    }

    public static int fun(int a,int b)
    {
        if(a%b==2)
            return  a;
        else
            return  fun(a+b,a-b);
    }
    public  void method(){
    }
}
