package TEST;

/**
 * @author : dk
 * @date : 2019/9/2 21:41
 * @description :
 * 请实现一个函数，把字符串中的每个空格替换成"%20"
 *
 * 例如输入"We are happy."
 *
 * 则输出"We%20are%20happy."
 */

public class Test3 {
    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length()-1;
        for (int i = 0; i <=p1; i++)
        {
            if (str.charAt(i)==' ')
            {
                str.append("  ");
            }
        }
        int p2 = str.length()-1;
        //此时p2 指向新增空间后的字符串的最后一个位置
        while (p1!=p2)
        {
            if (str.charAt(p1)!=' ')
            {
                str.setCharAt(p2, str.charAt(p1));
                p1--;
                p2--;
            }
            else
            {
                p1--;
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("we are happy.")));
    }
}
