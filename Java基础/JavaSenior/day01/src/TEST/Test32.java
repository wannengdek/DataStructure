package TEST;

import java.util.ArrayList;

/**
 * @author : dk
 * @date : 2019/10/1 00:54
 * @description :
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */


public class Test32
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
        {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0)
        {
            TreeNode temp = queue.remove(0);
            //remove(0)删除queue的第一个元素并将其返回，模拟了队列的弹出操作
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            list.add(temp.val);
        }
        return list;
    }
}

