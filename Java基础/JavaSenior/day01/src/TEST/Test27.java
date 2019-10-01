package TEST;

/**
 * @author : dk
 * @date : 2019/9/28 17:54
 * @description :
 * <p>
 * <p>
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */

public class Test27
{
    class TreeNode
    {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val)
        {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        else
        {
            if (root.right != null || root.left != null)
            {
                TreeNode node = null;
                node = root.right;
                root.right = root.left;
                root.left = node;
            }
            Mirror(root.right);
            Mirror(root.left);
        }
    }
//此注释为了纪念第一次没有查看书籍,手动编写直接过所有测试点
}
