package TEST;

/**
 * @author : dk
 * @date : 2019/9/27 19:03
 * @description :
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */

public class Test25
{
    //递归
    public ListNode Merge(ListNode list1,ListNode list2)
    {
        if (list1==null&&list2==null)
        {
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode newHead = null;
        if (list1.val<list2.val)
        {
            newHead = list1;
            newHead.next = Merge(newHead.next,list2);
        }else
        {
            newHead = list2;
            newHead.next = Merge(newHead.next,list1);
        }
        return newHead;
    }

    //非递归
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1==null&&list2==null)
        {
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode head = newHead;
        //利用新的节点去合并两条链表，最终返回的是 newHead  。
        //如果返回的是 head ，那么只是返回合并之后的最后一个节点
        while (list1!=null&&list2!=null)
        {
            if (list1.val>=list2.val)
            {
                head.next = list2;
                list2 = list2.next;
            }else
            {
                head.next = list1;
                list1=list1.next;
            }
            head = head.next;
        }
        if (list1!=null)
        {
            head.next = list1;
        }
        if (list2!=null)
        {
            head.next=list2;
        }
        return newHead.next;
    }
}
