package TEST;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dk
 * @date : 2019/9/4 13:41
 * @description :
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Test7 {
    private Map<Integer,Integer> inOrders=new HashMap<Integer,Integer>();
    public TreeNode reConstructBinaryTree(int [] pre,int [] in)
    {

        for (int i = 0; i < in.length; i++)
        {
            inOrders.put(in[i],i);
        }
        return core(pre,0,pre.length-1,0);

    }

    private TreeNode core(int[] pre, int preL, int preR, int inL)
    {
        if (preL>preR)
        {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIdex = inOrders.get(root.val);
        int leftTreeSize = inIdex-inL;
        root.left = core(pre,preL+1,preL+leftTreeSize,inL);
        /*
         * 第一次：
         * 在中序遍历序列中 找到前序遍历的第一个元素“1”的下标为3
         * 那么根节点为1的这棵树的左子树的总元素数量为3-0=3个
         * 第二次：
         * 对于这棵总元素数量为3的左子树 由于在前序遍历中左子树的遍历先于右子树
         * 所以preL+1 也就是前序遍历的下一个元素 即为这棵树的根节点
         * preR是这棵树元素的终点 即是preL+这棵树的规模
         * inL在构建右子树中解释
         */
        root.right = core(pre,preL+leftTreeSize+1,preR,inL+leftTreeSize+1);
        /*
         * 第一次：
         * 找到“1”的下标3之后
         * 这棵右子树的根节点（也就是在前序遍历序列的起点）为初始结点位置+左子树规模+1
         * 即对于5 3 8 6这棵数来说 要找它的根节点
         * 需要在前序遍历序列中偏移0+3+1个位置 故在前序遍历中的下标为4
         * preR不变 因为在前序遍历序列中 右子树永远在末尾
         * inL加上了左子树的规模+1是因为
         * 在3 5 6 8这棵树中 去中序遍历中找3的下标 发现为5
         * 这棵根节点为3的树 他的左子树的规模在计算时需要知道这棵树的起点
         * 而这棵树的起点 即是去掉和他同一深度的左兄弟树的规模 再减去他的父节点占用的1个位置
         * 所以inL是用于在构建右子树时计算规模的偏移记录量
         * 而在构建左子树时这个偏移量不需要变化是因为中序遍历是以左子树开头的 所以根节点的下标位置的数字就是左子树的规模
         * 他的左边没有其他元素占用位置
         */

        return root;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,7,3,5,6,8};
        int[] b = new int[]{};

    }
}
