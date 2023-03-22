package algorithm.linkedList.one;

import algorithm.linkedList.ListNode;

/**
 * @Description: 采用归并排序，用快慢指针找中点，断开为2个单独的链表
 * @Author: bsy
 * @Date: 2023/2/1 11:32
 */
public class SortIntList {

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head==null || head.next == null){
            return head;
        }

        //分开
        //左链表的最后一个指针
        ListNode left=head;
        ListNode mid=head.next;
        ListNode right = head.next.next;
        while(right !=null && right.next!=null){
            left = left.next;
            mid = mid.next;
            right = right.next.next;
        }
        //左链表断开
        left.next=null;
        return merge(sortInList(head), sortInList(mid));
    }

    public ListNode merge(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;
        while(list1 !=null && list2 != null){
            if(list1.val<list2.val){
                merge.next = list1;
                list1 = list1.next;
            }else{
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        if(list1!=null){
            merge.next = list1;
        }
        if(list2 != null){
            merge.next = list2;
        }
        return dummy.next;
    }
}
