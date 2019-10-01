package TEST;

/**
 * @author : dk
 * @date : 2019/9/27 19:07
 * @description :
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */

public class Test26
{
    public boolean HasSubtree(TreeNode root1, TreeNode root2)
    {

        boolean result = false;
        if (root1 != null && root2 != null)
        {
            if (root1.val == root2.val)
            {
                result = DoesTree1HaveTree2(root1, root2);
                //判断这两个节点的子节点是否相同
            }
            if (!result)
            {
                result = HasSubtree(root1.left, root2);
            }
            if (!result)
            {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2)
    {
//如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null)
        {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null)
        {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val)
        {
            return false;
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }
}
