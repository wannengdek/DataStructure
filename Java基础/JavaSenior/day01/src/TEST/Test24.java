package TEST;

import java.util.Stack;

/**
 * @author : dk
 * @date : 2019/9/26 10:00
 * @description :
 * 输入一个链表，反转链表后，输出新链表的表头。
 */


public class Test24
{
    /**
     * 建立一个栈，每次push进去节点，知道为空，
     * 然后每次pop出来的节点的next指针指向下一个pop出来的节点，直到栈为空。时间空间均为O（n）
     */
    public ListNode ReverseList(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return head;
        }
        ListNode p = head;
        Stack<ListNode> stack = new Stack();
        while (p.next != null)
        {
            stack.push(p);
            p = p.next;
        }
        ListNode newHead = p;
        while (!stack.empty())
        {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        //最后一个指向null
        return newHead;
    }

    /**
     * 维护2个指针，遍历的时候，
     * 直接将指针的指向逆序。时间O（n），空间O（1）。
     */
    public ListNode ReverseList1(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        if (head.next == null)
        {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null)
        {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归方法
     * 处理当前节点前，处理当前节点的下一个节点
     * 递归到最后一个节点开始处理
     */
    public static ListNode ReverseList2(ListNode pHead)
    {
        //如果链表为空或者链表中只有一个元素
        if(pHead==null||pHead.next==null) return pHead;

        //先反转后面的链表，走到链表的末端结点
        ListNode pReverseNode=ReverseList2(pHead.next);

        //再将当前节点设置为后面节点的后续节点
        pHead.next.next=pHead;
        pHead.next=null;

        return pReverseNode;
    }
    public static void main(String[] args)
    {


//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);
//        ListNode node7 = new ListNode(7);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//
//        ListNode old = node1;
//        while (old != null)
//        {
//            System.out.print(" " + old.val);
//            old = old.next;
//        }
//        System.out.println();
////        deleteDuplication(node1);
//        ListNode newNode = ReverseList2(node1);
//        while (newNode != null)
//        {
//            System.out.print(" " + newNode.val);
//            newNode = newNode.next;
//        }
    }



}


