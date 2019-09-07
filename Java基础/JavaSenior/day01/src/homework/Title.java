package homework;

/*
 */

public class Title
{
    private Integer score ;
    private Integer value ;

    public Title()
    {
    }

    public Title(Integer score, Integer value)
    {
        this.score = score;
        this.value = value;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }
}
