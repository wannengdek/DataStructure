package TEST;

import java.util.Stack;

/**
 * @author : dk
 * @date : 2019/9/25 00:05
 * @description :
 * <p>
 * 输入一个链表，输出该链表中倒数第k个结点。
 */

public class Test22
{
    //栈
    public ListNode FindKthToTail2(ListNode head, int k)
    {
        if (head == null || k == 0)
        {
            return null;
        }
        //可以先把链表反转，然后找出第k个
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 0;
        while (head != null)
        {
            stack.push(head);
            head = head.next;
            count++;
        }
        if (count < k)
        {
            return null;
        }
        int i = 0;
        ListNode node = null;
        while (i < k)
        {
            node = stack.pop();
            i++;
        }

        return node;

    }

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
}
