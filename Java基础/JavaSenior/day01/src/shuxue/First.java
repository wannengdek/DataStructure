package shuxue;



public class First
{
    public static int first()
    {
        int num = 0;
        //记录人数
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
        int []times =new int[1000];
        //存储每次模拟的结果 单位为秒
        for (int i = 0; i < 1000; i++)
        {
            times[i] = first();
            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+times[i] +" s");
        }
        int ave = 0;
        for (int j = 0; j < 1000 ; j++)
        {
            ave = ave + times[j];
        }
        System.out.println("方案一执行1000次程序所需的平均时间为 "+ ave/1000+" s");
    }
}
