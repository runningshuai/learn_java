package ds.sort.linkedListSeries;


/**
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *快慢指针方法
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead){
        if(pHead==null) return pHead;

        ListNode fast = pHead;
        ListNode slow = pHead;

        //判读是否有环，有环比相遇
        while(fast!=null&&fast.next!=null){
            //有环无法结束循环
            fast = fast.next.next; //只有两个数时，下次直接跳到null,此时fast是空
            slow = slow.next;
            //有环需要结束循环
            if(slow == fast){
                //快指针变慢
                fast = pHead;
                while(fast !=slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return  null;
    }
}
