package TEST;

/**
 * @author : dk
 * @date : 2019/9/4 15:34
 * @description :
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针
 */
class TreeLinkNode
{
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode last;
    int val;
    TreeLinkNode(int x) { this.val = x; }
}
public class Test8
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right!=null)
        {
            TreeLinkNode res = pNode;
            while (res.left!=null)
            {
                res= res.left;
            }
            return res;
        }
        else
        {
            if (pNode.last.left==pNode)
            {
                return pNode.last;
            }
            else if (pNode.last.right==pNode)
            {
                TreeLinkNode p =pNode;
                while (p.last!=null)
                //停止条件为父节点为空
                {
                    if (p.last.left==p)
                    {
                        return p.last;
                    }
                    p=p.last;
                }

            }
        }
        return null;
    }
}
