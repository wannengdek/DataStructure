package TEST;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author : dk
 * @date : 2019/9/2 21:41
 * @description :
 * 输入一个链表的头结点，从尾到头反过来打印出每个节点的值
 */

public class Test4 {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
        }
    }
    /**
     *但该方法若是输入的链表长度非常长时
     * 	  会导致函数调用的层级过深
     * 	  从而导致函数调用栈溢出（java.lang.StackOverflowError）
     */
    ArrayList<Integer> res=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null)
        {
            this.printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }

    /**
     * 调用栈
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack =new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }


    /**
     * 使用头插法
     * 每次都是将 新的元素作为头节点,
     * 原链表中最后的节点就放到了最后,然后返回这个新的链表.
     * 注意点：
     * 	 * 头结点是在头插法中使用的一个额外节点，这个节点不存储值
     * 	 * 第一个节点就是链表的第一个真正存储值的节点
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
     ListNode head = new ListNode(-1);
     while (listNode!=null)
     {
         ListNode node =new ListNode(listNode.val);
         node.next = head.next;
         head.next = node;
         listNode = listNode.next;
     }
        ArrayList<Integer> res=new ArrayList<Integer>();
        head = head.next;
        while(head!=null)
        {
            res.add(head.val);
            head=head.next;
        }
        return res;
    }




}
