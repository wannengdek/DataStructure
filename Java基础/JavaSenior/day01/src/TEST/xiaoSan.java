package TEST;

import java.util.ArrayList;

/**
 * @author : dk
 * @date : 2019/9/10 18:16
 * @description :
 */

public class xiaoSan extends San
{

    static class Song
    {
        private  int name ;

        public int getName()
        {
            return name;
        }
        public void setName(int name)
        {
            this.name = name;
        }
    }
    public static void main(String[] args)
    {
        Song song1 = new Song();
        Song song2 = new Song();
        ArrayList arrayList = new ArrayList();
        arrayList.add(song2);
        arrayList.add(song1);

        for (int i = 0; i < arrayList.size(); i++)
        {
            if (arrayList.get(i).equals(song1))
            {
                System.out.println("第"+ (i+1)+"个对象是给定的对象");
            }
        }




    }


}
