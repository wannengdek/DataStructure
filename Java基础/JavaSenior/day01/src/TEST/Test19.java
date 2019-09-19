package TEST;

/**
 * @author : dk
 * @date : 2019/9/9 18:53
 * @description :
 */

public class Test19
{
    //    public static int
    public static void second()
    {
        int num = 0;
        int num_now = 0;
        //车辆数
        int[] a = new int[7];
        for (int m = 0; m < a.length - 1; m++)
        {
            a[m] = 0;
        }
        boolean[] b = new boolean[7];
        for (int j = 0; j < b.length; j++)
        {
            b[j] = true;
        }
        int i = 0;
        int wastTime = 50 ;
        int addCarTime = 120;
        for (i = 1; ; i++)
        {
            System.out.println("时间：" + i + " 已走人数：" + num);
            int ran = (int) (1 + Math.random() * (5 - 0 + 1)); //随机车位
            System.out.println("随机车位：" + ran);
            if (b[ran])
            {
                a[ran] = i
                        + (int)(1+Math.random()*(240-60+1)) + addCarTime;
                System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(240-60+1))+" s ");
                b[ran] = false;
                num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                num = num + num_now;
                System.out.println("随机人数：" + num_now);
                System.out.println("------------------------------");
                i = i +(int)(1+Math.random()*(30-1+1));
                //下一个人到来的随机时间
            }
            else
            {
                if (a[ran] < i)
                {
                    a[ran] = i+ (int)(1+Math.random()*(240-60+1)) + addCarTime;
                    System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(240-60+1))+" s ");
                    b[ran] = false;
                    num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                    num = num + num_now;
                    System.out.println("随机人数：" + num_now);
                    System.out.println("------------------------------");
                    i = i +(int)(1+Math.random()*(30-1+1));
                    //下一个人到来的随机时间
                }
                else if (a[ran] > i)
                {
                    ran = (int) (1 + Math.random() * (5 - 0 + 1));
                    int flag = 1;
                    while (flag == 1)
                    {
                        if (a[ran] > i)
                        {
                            a[ran] = i+ (int)(1+Math.random()*(240-60+1)) + addCarTime;
                            System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(240-60+1))+" s ");
                            b[ran] = false;
                            num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                            num = num + num_now;
                            System.out.println("随机人数：" + num_now);
                            System.out.println("------------------------------");
                            i = i +(int)(1+Math.random()*(30-1+1));
                            //下一个人到来的随机时间
                            flag = 0;
                        }
                        else
                        {
                            ran = (int) (1 + Math.random() * (5 - 0 + 1));
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
                System.out.println("time" +time);
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        second();
    }

    public static void third()
    {
        int num = 0;
        int num_now = 0;
        //车辆数
        int[] a = new int[14];
        for (int m = 0; m < a.length - 1; m++)
        {
            a[m] = 0;
        }
        boolean[] b = new boolean[14];
        for (int j = 0; j < b.length; j++)
        {
            b[j] = true;
        }
        int i = 0;
        int addCarTime = 240;
        for (i = 1; ; i++)
        {
            System.out.println("时间：" + i + " 已走人数：" + num);
            int ran = (int) (1 + Math.random() * (13 - 0 + 1)); //随机车位
            System.out.println("随机车位：" + ran);
            if (b[ran])
            {
                a[ran] = i + (int)(1+Math.random()*(300-180+1)) + addCarTime;
                System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(300-180+1))+" s ");
                b[ran] = false;
                num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                num = num + num_now;
                System.out.println("随机人数：" + num_now);
                System.out.println("------------------------------");

                i = i +(int)(1+Math.random()*(30-1+1));
                //下一个人到来的随机时间
            }
            else
            {
                if (a[ran] < i)
                {
                    a[ran] = i+ (int)(1+Math.random()*(300-180+1)) + addCarTime;
                    System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(300-180+1))+" s ");
                    b[ran] = false;
                    num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                    num = num + num_now;
                    System.out.println("随机人数：" + num_now);
                    System.out.println("------------------------------");
                    i = i +(int)(1+Math.random()*(30-1+1));
                    //下一个人到来的随机时间
                }
                else if (a[ran] > i)
                {
                    ran = (int) (1 + Math.random() * (13 - 0 + 1));
                    int flag = 1;
                    while (flag == 1)
                    {
                        if (a[ran] > i)
                        {
                            a[ran] = i+ (int)(1+Math.random()*(300-180+1)) + addCarTime;
                            System.out.println("随机上车花费时间是："+(int)(1+Math.random()*(300-180+1))+" s ");
                            b[ran] = false;
                            num_now = (int) (1 + Math.random() * (3 - 1 + 1));//随机人数
                            num = num + num_now;
                            System.out.println("随机人数：" + num_now);
                            System.out.println("------------------------------");
                            i = i +(int)(1+Math.random()*(30-1+1));
                            //下一个人到来的随机时间
                            flag = 0;
                        }
                        else
                        {
                            ran = (int) (1 + Math.random() * (13 - 0 + 1));
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
                System.out.println("time" +time);
                break;
            }
        }
    }

}

