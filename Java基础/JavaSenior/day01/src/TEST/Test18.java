package TEST;

/**
 * @author : dk
 * @date : 2019/9/20 13:59
 * @description :
 *
 * 删除链表的节点
 *
 * 删除链表中重复的节点
 *
 * 牛客剑指offer ：找到倒数第k个节点
 *
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
    //找到倒数第k个节点

    /**
     *  定义快指针和慢指针。
     * 快指针先走 k-1 步，到达第 k 个节点。
     * 然后两指针同时齐步走，当快指针到达末尾时，慢指针在倒数第 k 个节点上。
     */
    public ListNode FindKthToTail(ListNode head, int k)
    {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++)
        {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return  slow;
    }


}
