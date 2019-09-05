package homework;


import java.util.Scanner;

public class Utils
{
    public static void menu()
    {
        System.out.println("please select from the following options");
        System.out.println("press 1 to register a player");
        System.out.println("press 2 to start a new game");
        System.out.println("press 3 to view a help menu");
        System.out.println("press 4 to exit");
    }
    public static void helpMenu()
    {
        System.out.println("游戏规则如下");
        System.out.println("1.每个玩家以零分开始游戏。");
        System.out.println("2.在每一轮之前，每个玩家都有以下五个方块。每个图块都有一个值和一个关联的分数:");
        System.out.println("3.除了上面的质数之外，不能播放任何其他牌值。当用户选择一个图块时，也必须验证这一点。对于不正确的选择，应显示一条错误消息，用户可以重新选择。");
        System.out.println("4.每个玩家都有相同的5张牌。每个玩家每轮只能使用5个文件中的一个。");
        System.out.println("5.在每一轮之前，游戏会自动决定是人类玩家先走还是电脑玩家先走。");
        System.out.println("6.对于每一轮，每个玩家将玩一张牌，牌值将增加到该轮的游戏总数中。");
        System.out.println("如果游戏总数小于或等于21，玩家将获得使用该牌的分数。然而，如果游戏总数大于21，则没有分数被分配");
        System.out.println("给玩最后一张牌的玩家，导致分数变得大于21");
    }

    public static void main(String[] args)
    {
        menu();
        helpMenu();
    }
    public static int inputNum()
    {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        return  num;
    }
}
