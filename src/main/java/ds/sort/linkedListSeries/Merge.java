package ds.sort.linkedListSeries;

/**
 *输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 空间复杂度 O(1),不能引入新链表，扫描一个链表，往另一个链表插入(在链表时不正确)
 *可以引入新的链表，但要保证新链表增加的时候，老链表在减少，从而保证总的存储空间不变
 * 归并排序一样的做法
 */
public class Merge {
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode yummy=new ListNode(0);
        ListNode cur = yummy;
        while(list1 != null && list2 != null){
            if(list1.val<list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next; //指针后移
        }
        cur.next = list1==null? list2:list1;
        return yummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        System.out.println(list1);
    }
}
