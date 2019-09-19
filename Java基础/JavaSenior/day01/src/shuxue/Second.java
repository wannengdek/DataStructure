package shuxue;



public class Second
{
    public static int second()
    {
        int num = 0;
        //记录人数
        int num_now = 0;
        //记录这次上车人数
        int[] a = new int[7];
        //记录车位使用时间
        for (int m = 0; m < a.length - 1; m++)
        {
            a[m] = 0;
        }
        boolean[] b = new boolean[7];
        //记录车位是否可以使用
        for (int j = 0; j < b.length; j++)
        {
            b[j] = true;
        }
        int i = 0;
        //记录时间
        int wastTime = 0 ;
        //记录此次上车消耗时间
        int addCarTime = 120;
        //蓄车区移动到上车区的所用的平均时间
        for (i = 1; ; i++)
        {
//            System.out.println("时间：" + i + " 已走人数：" + num);
            int ran = (int) (0 + Math.random() * (6-0+1));
            //随机车位
//            System.out.println("随机车位：" + ran);
            if (b[ran])
            {
                wastTime = (int)(60+Math.random()*(240-60+1));
                //消耗的时间
                a[ran] = i +wastTime + addCarTime;
//                System.out.println("随机上车花费时间是："+wastTime+" s ");
                b[ran] = false;
                num_now = (int) (1 + Math.random() * (3));
                //随机上车人数
                num = num + num_now;
//                System.out.println("随机人数：" + num_now);
//                System.out.println("------------------------------");
                i = i +(int)(1+Math.random()*(30));
                //下一个人到来的随机时间
            }
            else
            {
                if (a[ran] < i)
                {
                    wastTime = (int)(60+Math.random()*(240-60+1));
                    a[ran] = i+ wastTime+ addCarTime;
//                    System.out.println("随机上车花费时间是："+wastTime+" s ");
                    b[ran] = false;
                    num_now = (int) (1 + Math.random() * (3));//随机人数
                    num = num + num_now;
//                    System.out.println("随机人数：" + num_now);
//                    System.out.println("------------------------------");
                    i = i +(int)(1+Math.random()*(30));
                    //下一个人到来的随机时间
                }
                else if (a[ran] > i)
                {
                    ran = (int) (0 + Math.random() * (6));
                    int flag = 1;
                    while (flag == 1)
                    {
                        if (a[ran] > i)
                        {
                            wastTime = (int)(60+Math.random()*(240-60+1));
                            a[ran] = i+ wastTime + addCarTime;
//                            System.out.println("随机上车花费时间是："+wastTime+" s ");
                            b[ran] = false;
                            num_now = (int) (1 + Math.random() * (3));
                            //随机人数
                            num = num + num_now;
//                            System.out.println("随机人数：" + num_now);
//                            System.out.println("------------------------------");
                            i = i +(int)(1+Math.random()*(30));
                            //下一个人到来的随机时间
                            flag = 0;
                        }
                        else
                        {
                            ran = (int) (0 + Math.random() * (6-0+1));
                        }
                    }
                }
            }
            if (num > 1000)
            {
                int time = a[0];
                for (int j = 0; j < a.length-1; j++)
                {
                    if (time< a[j])
                    {
                        time = a[j];
                    }
                }
//                System.out.println("time" +time);
                return  time;
            }
        }
    }

    public static void main(String[] args)
    {
        int []times =new int[1000];
        //存储每次模拟的结果 单位为秒
        for (int i = 0; i < 1000; i++)
        {
            times[i] = second();
            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+times[i] +" s");
        }
        int ave = 0;
        for (int j = 0; j < 1000 ; j++)
        {
            ave = ave + times[j];
        }
        System.out.println("方案二执行1000次程序所需的平均时间为 "+ ave/1000+" s");
    }

}
