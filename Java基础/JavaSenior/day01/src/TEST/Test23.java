package TEST;

/**
 * @author : dk
 * @date : 2019/9/25 00:31
 * @description :
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

public class Test23
{
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
            //找到相遇点
        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        //慢指针从头开始
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
        //如果相遇返回环入口
    }
}
