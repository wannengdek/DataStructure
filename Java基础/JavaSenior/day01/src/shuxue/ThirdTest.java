package shuxue;


import java.util.ArrayList;

public class ThirdTest
{
    public static int num = 0;
    //记录人数
    public static int[] a = new int[14];
    //记录车位使用时间
    public static boolean[] b = new boolean[14];
    //记录车位是否可以使用
    public static int i = 0;

    public static void third()
    {

        int num_now = 0;
        //记录这次上车人数
        int wastTime = 0;
        //记录此次上车消耗时间
        int addCarTime = 300;
        //蓄车区移动到上车区的所用的平均时间

//            System.out.println("时间：" + i + " 已走人数：" + num);
        int ran = (int) (0 + Math.random() * (13 - 0 + 1)); //随机车位
//            System.out.println("随机车位：" + ran);
        if (b[ran])
        {
            wastTime = (int) (180 + Math.random() * (300 - 180 + 1));
            a[ran] = i + wastTime + (int) (240 + Math.random() * (360 - 240 + 1));
//                System.out.println("随机上车花费时间是：" + wastTime + " s ");
            b[ran] = false;
            num_now = (int) (1 + Math.random() * (3));//随机人数
            num = num + num_now;
//                System.out.println("随机人数：" + num_now);
//                System.out.println("------------------------------");
            i = i + (int) (1 + Math.random() * (30));
            //下一个人到来的随机时间
        }
        else
        {
            if (a[ran] < i)
            {
                wastTime = (int) (180 + Math.random() * (300 - 180 + 1));
                a[ran] = i + wastTime + (int) (240 + Math.random() * (360 - 240 + 1));
//                    System.out.println("随机上车花费时间是：" + (int) (180 + Math.random() * (300-180+1)) + " s ");
                b[ran] = false;
                num_now = (int) (1 + Math.random() * (3));//随机人数
                num = num + num_now;
//                    System.out.println("随机人数：" + num_now);
//                    System.out.println("------------------------------");
                i = i + (int) (1 + Math.random() * (30));
                //下一个人到来的随机时间
            }
            else if (a[ran] > i)
            {
                ran = (int) (0 + Math.random() * (13 - 0 + 1));
                int flag = 1;
                while (flag == 1)
                {
                    if (b[0] || b[1] || b[2] || b[3] || b[4] || b[5] || b[6] || b[7] || b[8] || b[9] || b[10] || b[11] || b[12] || b[13])
                    {
                        flag = 0;
                    }
                    if (a[ran] > i)
                    {
                        wastTime = (int) (180 + Math.random() * (300 - 180 + 1));
                        a[ran] = i + wastTime + (int) (240 + Math.random() * (360 - 240 + 1));
//                            System.out.println("随机上车花费时间是：" +wastTime + " s ");
                        b[ran] = false;
                        num_now = (int) (1 + Math.random() * (3));//随机人数
                        num = num + num_now;
//                            System.out.println("随机人数：" + num_now);
//                            System.out.println("------------------------------");
                        i = i + (int) (1 + Math.random() * (30 - 1 + 1));
                        //下一个人到来的随机时间
                        flag = 0;
                    }
                    else
                    {
                        ran = (int) (0 + Math.random() * (13 - 0 + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList arrayList = new ArrayList();
        //存储每次模拟的结果 单位为秒
        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third1());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        int ave = 0;
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用1个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third2());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用2个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third3());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用3个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third4());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用4个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third5());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用5个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third6());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用6个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third7());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用7个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third8());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用8个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third9());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用9个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third10());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用10个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third11());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用11个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third12());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用12个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third13());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用13个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;

        for (int i = 0; i < 1000; i++)
        {
            arrayList.add(third14());
//            System.out.println("第 "+(i+1)+" 次执行程序，"+"花费时间为 ："+arrayList.get(i) +" s");
        }
        for (int j = 0; j < 1000; j++)
        {
            ave = ave + (int) arrayList.get(j);
        }
        System.out.println("方案三使用14个上车点执行1000次程序所需的平均时间为 " + ave / 1000 + " s");
        arrayList.clear();
        ave = 0;
    }

    public static int third14()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third13()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();

        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third12()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third11()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third10()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third9()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();

            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third8()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();

            third();
            third();

            third();
            third();

            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third7()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
            third();
            third();
            third();
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third6()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
            third();
            third();
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third5()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
            third();
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third4()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third3()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third2()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }
    public static int third1()
    {
        while (num < 1000)
        {
            i = i + 1;
            third();
        }
        int max = 0;
        for (int j = 0; j < a.length; j++)
        {
//            System.out.print(a[j]+ " ");
            if (max < a[j])
            {
                max = a[j];
            }
        }
//        System.out.println(" ");
//        System.out.println("max " + max);
        init();
        return max;
    }

    public static void init()
    {
        //初始化所有参数
        for (int j = 0; j < a.length; j++)
        {
            a[j] = 0;
        }
        for (int m = 0; m < b.length; m++)
        {
            b[m] = true;
        }
        num = 0;
        i = 0;
    }
}
