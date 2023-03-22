package ds.sort.linkedListSeries;

/**
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 窍门：x + z + y = y + z + x
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if(pHead1 == null || pHead2 == null) return null;
        //pHead1，pHead2需要完整保留
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;

        while(l1 != l2){
            l2 = l2==null?pHead1:l2.next;
            l1 = l1 ==null?pHead2:l1.next;
        }

        return l1;
    }
}
