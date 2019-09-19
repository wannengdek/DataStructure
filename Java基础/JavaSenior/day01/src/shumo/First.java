package shumo;


public class First
{
    public static void first()
    {
        int i = 0 ;
        int num = 0;
        int timeNow = 0;
        for (i=1 ; ;i++)
        {
            timeNow =timeNow + (int) (120 + Math.random() * (240-120+1))+60;
            System.out.println("上车消耗"+ (int)(120 + Math.random() * (240-120+1))+60+"s");
             if (i<timeNow)
             {
                 System.out.println("不能上车");
             }
             else
             {
                 num = num +  (int) (1 + Math.random() * (3));
                 System.out.println("此次上车"+num+"人");
             }
            if (num>500)
            {
                System.out.println(timeNow);
                break;
            }
        }
    }

    public static void main(String[] args)
    {
//        first();
        for (int i =0 ;i<100;i++)
        {
            System.out.println((int) (120 + Math.random() * (240 - 120 + 1)));
        }
    }
}
