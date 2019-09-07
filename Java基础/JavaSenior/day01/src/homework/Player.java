package homework;

import java.util.Arrays;

/**
 *
 */

public class Player
{
    private String name;
    private Integer score;
    private Title[] titles;
    private Title lastTilePlayed;
    private Integer roundsWon;

    public Player()
    {

    }

    public Player(int score, Integer roundsWon)
    {
        this.score = score;
        this.roundsWon = 0;
    }

    public Player(String username, int score, Integer roundsWon)
    {
        this.name = username;
        this.score = score;
        this.roundsWon = 0;
    }

    public Player(String name, Integer score, Title[] titles, Title lastTilePlayed, Integer roundsWon)
    {
        this.name = name;
        this.score = 0;
        this.titles = titles;
        this.lastTilePlayed = lastTilePlayed;
        this.roundsWon = roundsWon;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public Title[] getTitles()
    {
        return titles;
    }

    public void setTitles(Title[] titles)
    {
        this.titles = titles;
    }

    public Title getLastTilePlayed()
    {
        return lastTilePlayed;
    }

    public void setLastTilePlayed(Title lastTilePlayed)
    {
        this.lastTilePlayed = lastTilePlayed;
    }

    public Integer getRoundsWon()
    {
        return roundsWon;
    }

    public void setRoundsWon(Integer roundsWon)
    {
        this.roundsWon = roundsWon;
    }

    @Override
    public String toString()
    {
        return "Player{" + "name='" + name + '\'' + ", score=" + score + ", titles=" + Arrays.toString(titles) + ", lastTilePlayed=" + lastTilePlayed + ", roundsWon=" + roundsWon + '}';
    }
}
