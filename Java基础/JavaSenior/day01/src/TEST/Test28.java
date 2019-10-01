package TEST;

/**
 * @author : dk
 * @date : 2019/9/28 22:24
 * @description :
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * ​	    2
 *
 *   3   3  		这样的二叉树称为对称的。
 *
 * 7 5  5 7
 */

public class Test28
{
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null)
            return true;
        return core(pRoot.left,pRoot.right);
    }
    private boolean core(TreeNode root1,TreeNode root2)
    {
        if (root1==null&&root2==null)
            return true;
        if(root1==null||root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return core(root1.left,root2.right)&&core(root1.right,root2.left);
    }


}
