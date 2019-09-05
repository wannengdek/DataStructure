package homework;


import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

public class Game
{
    public static Player player1 = new Player("player1", 0);
    public static Player robot = new Player("robot", 0);
    public static int rounds = 0;
    public static HashMap hashMapPlayer = new HashMap();
    public static HashMap hashMapRobot = new HashMap();
    public static int totalScope = 0;

    public static void playGame()
    {
        int i = 0;
        boolean flag = true;
        while (i != 2)
        {
            if (flag)
            {
                System.out.println("现在玩家出手,请输入");
                boolean flag1 = true;
                int playerNewScore = 0;
                int playerNum = 0;
                while (flag1)
                {
                    playerNum = Utils.inputNum();
                    playerNewScore = (int) hashMapPlayer.get(playerNum);
                    if (playerNewScore == 0)
                    {
                        System.out.println("error input,please input again");
                        continue;
                    }
                    else
                    {
                        flag1 = false;
                        hashMapPlayer.replace(playerNum, playerNewScore, 0);
                    }
                }
                int playerOldScore = player1.getScore();
                totalScope = totalScope + playerNum;
                if (totalScope >= 21)
                {
                    //结算
                    System.out.println("结算");
                    i = 2;
                }
                else
                {
                    player1.setScore(playerOldScore + playerNewScore);
                    System.out.println(player1.getName() + " :玩家出 " + playerNum + " 游戏总数: " + totalScope + " 人类玩家得分: " + (playerOldScore + playerNewScore));
                    flag = !flag;
                }
            }
            else
            {
                System.out.println("机器人出手");
                //玩家出手
                if (totalScope >= 21)
                {
                    //结算
                    System.out.println("结算");
                    i = 2;
                }
                else
                {
                    boolean flag2 = true;
                    int RobotNewScore = 0;
                    int RobotNum = 0;


                    while (flag2)
                    {
                        RobotNum = Utils.inputNum();
                        RobotNewScore = (int) hashMapRobot.get(RobotNum);
                        if (RobotNewScore == 0)
                        {
                            System.out.println("error input,please input again");
                            continue;
                        }
                        else
                        {
                            flag2 = false;
                            hashMapRobot.replace(RobotNum, RobotNewScore, 0);
                        }
                    }


                    int robotOldScore = robot.getScore();
                    totalScope = totalScope + RobotNum;

                    robot.setScore(robotOldScore + RobotNewScore);
                    System.out.println(player1.getName() + "  :玩家出 " + RobotNum + "   [游戏总数]:  " + totalScope + "  机器人得分: " + (robotOldScore + RobotNewScore));
                    flag = !flag;
                }
            }
            if (rounds >= 21)
            //结算
            {
                if (rounds == 21)
                {
                    //结算
                    System.out.println("结算");
                    i = 2;
                }
                else
                {
                    //结算
                    System.out.println("结算");
                    i = 2;
                }
            }

        }
    }


    public static void main(String[] args)
    {
        initHashMap();
//        playGame();
        //menu();
        int[] a = new int[]{1, 2, 3, 5, 7};
        int[] b = new int[]{1, 2, 3, 5, 7};
        int[] c = new int[15];

        shuchu(a,b,c);


    }
    public static void shuchu(int[] a, int[] b, int[] c)
    {
        int num = 0;
        for (int i = 0; i < 5; i++)
        {
            num = a[i]+b[i+5];
            if (num>=21)
            {
                if (num==21)
                {
                    if (i%2==0)
                    //先手的赢
                    {
                        c[10]=1;
                        System.out.println("先手胜");
                    }
                    else
                    {
                        c[11]=1;
                        System.out.println("后手胜");
                    }
                }
            }
            else
            {
                c[i]=a[i];
                c[i+1]=b[i];
                c[12]=c[12]+(int)hashMapPlayer.get(a[i]);
                c[13]=c[13]+(int)hashMapRobot.get(b[i]);
            }
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
                System.out.println(player1.getName());
                if (player1.getName() == null)
                {
                    System.out.println("you should have a name,please regist a new name");
                    menu();
                }
                else
                {
                    System.out.println(player1.getName() + "e");
                    System.out.println("Please select the number of rounds");
                    rounds = Utils.inputNum();
//                    for (int i = 0; i <rounds ; i++)
//                    {
//
//                    }
                    playGame();
                    if (player1.getRoundsWon() > robot.getRoundsWon())
                    {
                        System.out.println(player1.getName() + "win!!!");


                        // 重置所有

                        menu();

                    }
                    else
                    {
                        System.out.println("robot win!!!");


                        menu();
                    }
                }
                break;
            case 3:
                menu();
                break;
            case 4:
                System.out.println("end");
                exit(-1);
            default:
            {

            }
        }
    }

    public static void initHashMap()
    {
        hashMapPlayer.remove(1);
        hashMapPlayer.remove(2);
        hashMapPlayer.remove(3);
        hashMapPlayer.remove(5);
        hashMapPlayer.remove(7);
        hashMapPlayer.put(1, 5);
        hashMapPlayer.put(2, 4);
        hashMapPlayer.put(3, 3);
        hashMapPlayer.put(5, 2);
        hashMapPlayer.put(7, 1);
        hashMapRobot.remove(1);
        hashMapRobot.remove(2);
        hashMapRobot.remove(3);
        hashMapRobot.remove(5);
        hashMapRobot.remove(7);
        hashMapRobot.put(1, 5);
        hashMapRobot.put(2, 4);
        hashMapRobot.put(3, 3);
        hashMapRobot.put(5, 2);
        hashMapRobot.put(7, 1);
    }

    public static String regist()
    {
        System.out.println("please input your name,name must be between 3 and 10 characters inclusive.");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        rounds--;
        return s;
    }
}
