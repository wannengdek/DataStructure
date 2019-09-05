package homework;

import java.util.Random;

public class RNG
{
    private Integer maximumValue;
    private Integer minimumValue;

    public static Integer RNG(Integer maximumValue, Integer minimumValue)
    {
        Random r = new Random();
        int randomnum = r.nextInt(maximumValue) - minimumValue;
        // 生成[min,max]区间的整数
        return randomnum;
    }

    public static void main(String[] args)
    {
        System.out.println(RNG(1000, 100));
    }
}
