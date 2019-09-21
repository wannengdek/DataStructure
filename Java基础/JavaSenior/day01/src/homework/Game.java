package homework;


import java.util.Scanner;

import static java.lang.System.exit;

public class Game
{
    public static Player player1 = new Player(0, 0);
    public static Player robot = new Player("robot", 0, 0);

    public static int totalScope = 0;

    public static int rounds = 0;

    public static int playerWinTimes = 0;
    public static int robotWinTimes = 0;

    public static Title palyerTitle1 = new Title(1, 5);
    public static Title palyerTitle2 = new Title(2, 4);
    public static Title palyerTitle3 = new Title(3, 3);
    public static Title palyerTitle5 = new Title(5, 2);
    public static Title palyerTitle7 = new Title(7, 1);

    public static Title robotTitle1 = new Title(1, 5);
    public static Title robotTitle2 = new Title(2, 4);
    public static Title robotTitle3 = new Title(3, 3);
    public static Title robotTitle5 = new Title(5, 2);
    public static Title robotTitle7 = new Title(7, 1);

    public static Title[] titlesPlayer = new Title[5];
    public static int playerTitleNumer = 0;
    public static Title[] titlesRobot = new Title[5];
    public static int robotTitleNumer = 0;

    public static void playGame()
    {
        int i = 0;
        boolean flag = true;
        while (i != 2)
        {
            //判斷是否夠21
            if (flag)
            {
                //玩家回合
                if (totalScope >= 21)
                {
                    if (totalScope == 21)
                    {
                        // 机器人获胜
                        System.out.println(robot.getName() + " make it 21 point !!! " + " The score is " + robot.getScore());
                        i = 2;
                    }
                    else
                    //爆掉的情况
                    {
                        //先手的爆掉的
                        System.out.println("机器人爆掉的");
                        System.out.println("结算");
                        i = 2;
                    }
                }
                else
                {
                    System.out.println("现在玩家出手,请输入");
                    boolean flag1 = true;
                    int playerNewScore = 0;
                    int playerNum = 0;
                    while (flag1)
                    {
                        playerNum = Utils.inputNum();
                        switch (playerNum)
                        {
                            case 1:
                                playerNewScore = palyerTitle1.getValue();
                                break;
                            case 2:
                                playerNewScore = palyerTitle2.getValue();
                                break;
                            case 3:
                                playerNewScore = palyerTitle3.getValue();
                                break;
                            case 5:
                                playerNewScore = palyerTitle5.getValue();
                                break;
                            case 7:
                                playerNewScore = palyerTitle7.getValue();
                                break;
                        }
                        if (playerNewScore == 0)
                        {
                            System.out.println("error input,please input again");
                            continue;
                        }
                        else
                        {
                            flag1 = false;
                            titlesPlayer[playerTitleNumer] = selectPlayerTitle(playerNum);
                            playerTitleNumer++;
                            player1.setLastTilePlayed(selectPlayerTitle(playerNum));
                            updatePlayerTitle(playerNum);
                        }
                    }
                    int playerOldScore = player1.getScore();
                    totalScope = totalScope + playerNum;
                    player1.setScore(playerOldScore + playerNewScore);
                    System.out.println(player1.getName() + "    :玩家出    " + playerNum + "   游戏总数:   " + totalScope + "  人类玩家得分:  " + (playerOldScore + playerNewScore));
                    System.out.println();
                    flag = !flag;
                }
            }
            else
            {
                int RobotNum = 0;
                int robotNewScore = 0;
                if (totalScope >= 21)
                {
                    if (totalScope == 21)
                    {
                        //玩家获胜
                        System.out.println(player1.getName() + " make it 21 point " + " The score is " + player1.getScore());
                        i = 2;
                    }
                    else
                    //爆掉的情况
                    {
                        System.out.println("机器人爆掉的");
                        i = 2;
                    }
                }
                else if (totalScope == 20)
                {
                    //robot出手
                    boolean flag2 = true;
//                    int robotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = 1;
                        System.out.println("机器人发现此时totalScope=" + totalScope + "出 " + RobotNum);
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                System.out.println("但是 " + RobotNum + " 被使用过,故放弃");
                                RobotNum = randomNumber();
                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
                else if (totalScope == 19)
                {
                    //robot出手
                    boolean flag2 = true;
//                    int RobotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = 2;
                        System.out.println("机器人发现此时totalScope=" + totalScope + "出 " + RobotNum);
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                System.out.println("但是 " + RobotNum + " 被使用过,故放弃");
                                RobotNum = randomNumber();

                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
                else if (totalScope == 18)
                {
                    //robot出手
                    boolean flag2 = true;
//                    int RobotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = 3;
                        System.out.println("机器人发现此时totalScope=" + totalScope + "出 " + RobotNum);
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                System.out.println("但是 " + RobotNum + " 被使用过,故放弃");
                                RobotNum = randomNumber();
                                while (palyerTitle1.getValue()!=0&&palyerTitle2.getValue()!=0&&RobotNum==2)
                                {
                                    RobotNum = randomNumber();
                                }
                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
                else if (totalScope == 16)
                {
                    //robot出手
                    boolean flag2 = true;
                    int RobotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = 5;
                        System.out.println("机器人发现此时totalScope=" + totalScope + "出 " + RobotNum);
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                System.out.println("但是 " + RobotNum + " 被使用过,故放弃");
                                RobotNum = randomNumber();
                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
                else if (totalScope == 14)
                {
                    //robot出手
                    boolean flag2 = true;
                    int RobotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = 7;
                        System.out.println("机器人发现此时totalScope=" + totalScope + "出 " + RobotNum);
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                RobotNum = randomNumber();
                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
                else
                {
                    //robot出手
                    boolean flag2 = true;
                    int RobotNewScore = 0;
                    RobotNum = 0;
                    while (flag2)
                    {
                        RobotNum = randomNumber();
                        int e = 0;
                        while (e == 0)
                        {
                            if (selectRobotTitle(RobotNum).getValue() == 0)
                            {
                                RobotNum = randomNumber();
                            }
                            else
                            {
                                robotNewScore = selectRobotTitle(RobotNum).getValue();
                                e = 1;
                            }
                        }
                        flag2 = false;
                        updateRobotTitle(RobotNum);
                        int robotOldScore = robot.getScore();
                        totalScope = totalScope + RobotNum;
                        robot.setScore(robotOldScore + robotNewScore);
                        System.out.println(robot.getName() + "  :玩家出    " + RobotNum + "    游戏总数:   " + totalScope + "  机器人得分:  " + (robotOldScore + robotNewScore));
                        System.out.println();
                        flag = !flag;
                    }
                }
            }
        }
        //此回合结束 进行结算

        int playerLastScore = player1.getScore();
        int titlePlayer5 = tiltle5Use(player1) ? 0 : -3;
        if (titlePlayer5 == -3)
        {
            System.out.println("Players who do not use cards with a value of 5 will be fined 3 points.");
            System.out.println(player1.getName() + " 没有使用五");
            System.out.println(player1.getName() + " 最终分数是 " + (playerLastScore + titlePlayer5));
        }
        player1.setScore((playerLastScore + titlePlayer5));


        int robotLastScore = robot.getScore();
        int titleRobot5 = tiltle5Use(robot) ? 0 : -3;
        if (titleRobot5 == -3)
        {
            System.out.println("Players who do not use cards with a value of 5 will be fined 3 points.");
            System.out.println(robot.getName() + " 没有使用五");
            System.out.println(robot.getName() + " 最终分数是 " + (robotLastScore + titleRobot5));
        }
        robot.setScore((robotLastScore + titleRobot5));


        if (robot.getScore() > player1.getScore())
        {
            int wintimes = robot.getRoundsWon() + 1;
            robot.setRoundsWon(wintimes);
            System.out.println(robot.getName() + " win this time ");
            System.out.println("robot此時：" + robot.toString());
        }
        else if (robot.getScore() == (int) player1.getScore())
        {
            int wintimes = robot.getRoundsWon() + 1;
            robot.setRoundsWon(wintimes);

            System.out.println("robot此時：" + robot.toString());
            int wintimes1 = player1.getRoundsWon() + 1;
            player1.setRoundsWon(wintimes1);

            System.out.println(player1.getName() + "此時：" + player1.toString());
            System.out.println("It ends in a draw");
            System.out.println(" ");
        }
        else
        {
            int wintimes1 = player1.getRoundsWon() + 1;
            player1.setRoundsWon(wintimes1);
            System.out.println(player1.getName() + " win this time ");
            System.out.println(player1.getName() + "此時：" + player1.toString());
        }
    }

    public static boolean tiltle5Use(Player player)
    {
        if (player.getName() == "robot")
        {
            if (selectRobotTitle(5).getValue() == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if (selectPlayerTitle(5).getValue() == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public static int randomNumber()
    {
        int[] a = new int[]{1, 2, 3, 5, 7};
        Integer rng = RNG.RNG(4, 0);

        return a[rng];
    }

    public static Title selectPlayerTitle(int playerNum)
    {
        switch (playerNum)
        {
            case 1:
                return palyerTitle1;
            case 2:
                return palyerTitle2;
            case 3:
                return palyerTitle3;
            case 5:
                return palyerTitle5;
            case 7:
                return palyerTitle7;
            default:
        }
        return null;
    }


    public static Title selectRobotTitle(int robotNum)
    {
        switch (robotNum)
        {
            case 1:
                return robotTitle1;
            case 2:
                return robotTitle2;
            case 3:
                return robotTitle3;
            case 5:
                return robotTitle5;
            case 7:
                return robotTitle7;
            default:
        }
        return null;
    }


    public static void main(String[] args)
    {
        initTitle();
        menu();
    }

    public static void updatePlayerTitle(int updateplayerNum)
    {
        switch (updateplayerNum)
        {
            case 1:
                palyerTitle1.setValue(0);
                break;
            case 2:
                palyerTitle2.setValue(0);
                break;
            case 3:
                palyerTitle3.setValue(0);
                break;
            case 5:
                palyerTitle5.setValue(0);
                break;
            case 7:
                palyerTitle7.setValue(0);
                break;
            default:
        }
    }

    public static void updateRobotTitle(int playerNum)
    {
        switch (playerNum)
        {
            case 1:
                robotTitle1.setValue(0);
                break;
            case 2:
                robotTitle2.setValue(0);
                break;
            case 3:
                robotTitle3.setValue(0);
                break;
            case 5:
                robotTitle5.setValue(0);
                break;
            case 7:
                robotTitle7.setValue(0);
                break;
            default:
        }
    }

    public static void menu()
    {
        Scanner scanner = new Scanner(System.in);
        Utils.menu();
        int a = scanner.nextInt();
        switch (a)
        {
            case 1:
                String username = regist();
                player1.setName(username);
                menu();
                break;
            case 2:
                //System.out.println(player1.getName());
                if (player1.getName() == null)
                {
                    System.out.println("you should have a name,please regist a new name");
                    System.out.println(" ");
                    menu();
                }
                else
                {
                    System.out.println("Please select the number of rounds");
                    int times = Utils.inputNum();
                    for (int i = 0; i < times; i++)
                    {
                        playGame();
                        System.out.println("第 " + (i + 1) + " 回合结束");
                        System.out.println();
                        if ((i + 1) != times)
                        {
                            System.out.println("第 " + (i + 2) + " 回合开始");
                        }
                        initTitle();
                    }
                    if (player1.getRoundsWon() > robot.getRoundsWon())
                    //玩家获胜
                    {
                        System.out.println(player1.getName() + "win!!!");
                        System.out.println(" ");
                        // 重置所有
                        initTitle();
                        menu();
                    }
                    else if (player1.getRoundsWon() < robot.getRoundsWon())
                    //机器人获胜
                    {
                        System.out.println("robot win!!!");
                        System.out.println(" ");
                        // 重置所有
                        initTitle();
                        menu();
                    }
                    else
                    {
                        System.out.println("It ends in a draw");
                        System.out.println(" ");
                        // 重置所有
                        initTitle();
                        menu();
                    }
                }
                break;
            case 3:
                Utils.helpMenu();
                menu();
                break;
            case 4:
                System.out.println("end");
                exit(-1);
            default:
            {
                System.out.println("error input!");
                menu();
            }
        }
    }

    public static void initTitle()
    {
        palyerTitle1.setValue(5);
        palyerTitle2.setValue(4);
        palyerTitle3.setValue(3);
        palyerTitle5.setValue(2);
        palyerTitle7.setValue(1);

        for (int i = 0; i < 5; i++)
        {
            titlesPlayer[i] = null;
            titlesRobot[i] = null;
        }

        robotTitle1.setValue(5);
        robotTitle2.setValue(4);
        robotTitle3.setValue(3);
        robotTitle5.setValue(2);
        robotTitle7.setValue(1);

        rounds = 0;
        totalScope = 0;
        playerWinTimes = 0;
        robotWinTimes = 0;

        playerTitleNumer = 0;
        robotTitleNumer = 0;

        player1.setScore(0);
//        player1.setRoundsWon(0);
        robot.setScore(0);
//        robot.setRoundsWon(0);

    }

    public static String regist()
    {
        System.out.println("please input your name,name must be between 3 and 10 characters inclusive.");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        while (s.length() > 10 || s.length() < 3)
        {
            System.out.println("error input");
            s = scanner.nextLine();
        }
        return s;
    }
}
