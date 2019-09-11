package homework;

import java.util.Random;

public class RNG
{
    private Integer maximumValue;
    private Integer minimumValue;

    public RNG()
    {
    }

    public RNG(Integer maximumValue, Integer minimumValue)
    {
        this.maximumValue = maximumValue;
        this.minimumValue = minimumValue;
    }

    public static Integer RNG(Integer maximumValue, Integer minimumValue)
    {
        Random r = new Random();
        int randomnum = r.nextInt(maximumValue) - minimumValue;
        // 生成[min,max]区间的整数
        return randomnum;
    }

}
