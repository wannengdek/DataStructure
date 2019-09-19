package shuxue;


public class FirstTest
{
    public static int num = 0;
    //记录人数
    public static int first()
    {
        int timeNow = 0;
        //记录此次程序运行时间
        int numNow = 0;
        //记录这次上车人数
        int time =0;
        //记录这次上车所消耗的时间
        while (num<500)
        {
            numNow =  (int) (1 + Math.random() * (3));
            num = num + numNow ;
//            System.out.println("此次上车"+numNow+"人");
            time = (int)(120 + Math.random() * (240-120+1))+60;
//            System.out.println("上车消耗"+ time);
            timeNow = timeNow + time;
//            System.out.println(timeNow+"-----");
//            System.out.println("目前一共有"+num +"人");
        }
        return timeNow*2;
    }

    public static void main(String[] args)
    {

    }
}
