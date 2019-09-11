package TEST;

import java.util.*;

/**
 * @author : dk
 * @date : 2019/9/10 18:16
 * @description :
 */

public class xiaoSan extends San
{

    private int xiaol1;
    public xiaoSan()
    {
        super();
    }
    public void get()
    {
        super.get();
    }



    public static void main(String[] args)
    {
//        xiaoSan xiaoSan = new xiaoSan();
//        xiaoSan.get();

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        HashMap<Integer,Integer> hashMap = new HashMap();
        int a [] = new int[2];
        for(int i =0;i<m ;i++)
        {
            int key =scanner.nextInt();
            int v = scanner.nextInt();
            hashMap.put(key,v);
        }
        int a3 = find(m,n,hashMap);


    }

    public static int find(int m, int n, HashMap<Integer, Integer> hashMap)
    {
        int num = 0;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getKey()>n)
            {
                num = num +entry.getValue();
            }
            hashMap.replace(entry.getKey(),entry.getValue(),0);
            if (entry.getKey()<n)
            {
                arrayList.add(entry.getKey());
                arrayList.add(entry.getValue());
            }
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        return 0;
    }

}
