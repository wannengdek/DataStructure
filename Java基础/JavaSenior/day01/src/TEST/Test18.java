package TEST;

/**
 * @author : dk
 * @date : 2019/9/20 13:59
 * @description :
 * <p>
 * 删除链表的节点
 * <p>
 * 删除链表中重复的节点
 * <p>
 * 牛客剑指offer ：找到倒数第k个节点
 */
class ListNode
{
    int val;
    ListNode next = null;

    ListNode(int val)
    {
        this.val = val;
    }
}

public class Test18
{
    //删除链表的节点

    /**
     * 遍历一遍等于白给   O（n）
     * <p>
     * 假设    1-2-3-4-5-6-7-8-9
     * <p>
     * 当删除   2 这个节点的时候，  把2 之后的第一个节点3复制到2上，删除3这个节点就行了
     * 3-4-5-6-7-8-9
     * 1-2-3-4-5-6-7-8-9  删除之后就 相当于1-3-4-5-6-7-8-9
     */
    public void deleteNode(ListNode head, ListNode node)
    {
        if (head == null || node == null)
        //输入有误  返回
        {
            return;
        }
        if (head == node)
        //删除节点就是头节点
        {
            head = null;
            node = null;
            return;
        }
        if (node.next != null)
        //删除节点在链表中
        {
            ListNode node1 = node.next;
            //node1 此时是待删节点的下一个节点
            node.val = node1.val;
            // 将待删节点的下一个节点 的 val 赋值给  待删节点
            node.next = node1.next;
            //将待删节点的下一个节点 的 指针 赋给 待删节点
        }
        else
        {
            ListNode temp = head;
            while (temp.next != node)
            {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    //删除链表里的重复节点
    //非递归版本
    public static ListNode deleteRepeatNode1(ListNode pHead)
    {
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null)
        {
            if (cur.next != null && cur.next.val == cur.val)
            {
                while (cur.next != null && cur.next.val == cur.val)
                {
                    cur = cur.next;
                }
                cur = cur.next;
                if (pre == null) pHead = cur;
                else pre.next = cur;
            }
            else
            {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
    //https://www.cnblogs.com/yongh/p/9672004.html#_label2

    //删除链表里的重复节点
    //递归版本
    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null)
        //输入有误  返回
        {
            return null;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val)
        {
            while (next != null && pHead.val == next.val)
            //需要先判断是否为空
            {
                next = next.next;
                //找到下一个
            }
            return deleteDuplication(next);
        }
        else
        {
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }


    //找到倒数第k个节点

    /**
     * 定义快指针和慢指针。
     * 快指针先走 k-1 步，到达第 k 个节点。
     * 然后两指针同时齐步走，当快指针到达末尾时，慢指针在倒数第 k 个节点上。
     */
    public ListNode FindKthToTail(ListNode head, int k)
    {
        if (head == null || k <= 0)
        {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++)
        {
            if (fast.next == null)
            {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode old = node1;
        while (old != null)
        {
            System.out.print(" " + old.val);
            old = old.next;
        }
        System.out.println();
//        deleteDuplication(node1);
        ListNode newNode = deleteRepeatNode1(node1);
        while (newNode != null)
        {
            System.out.print(" " + newNode.val);
            newNode = newNode.next;
        }
    }


}
