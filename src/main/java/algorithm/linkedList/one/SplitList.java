package algorithm.linkedList.one;

import algorithm.linkedList.BuildLinkedList;
import algorithm.linkedList.ListNode;

/**
 * @Description: 给定一个值x，分解一个链表，使得小于x的节点在头部，大于的尾部
 * @Author: bsy
 * @Date: 2022/12/1 1:24
 */
public class SplitList {
    ListNode partitionList(ListNode head, int x){
        //bad case
        if(head == null){
            return null;
        }

        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);
        ListNode yummyLow = low;
        ListNode yummyHigh = high;

        while(head != null){
            if(head.val < x){
                low.next = new ListNode(head.val);
                low = low.next;
            }else{
                high.next = new ListNode(head.val);
                high = high.next;
            }
            head = head.next;
        }
        low.next = yummyHigh.next;
        return yummyLow.next;
    }

    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildRandomLinkedList();
        SplitList splitList = new SplitList();

        ListNode cur = splitList.partitionList(demoList, 5);
        while (cur != null){
            if(cur.next != null){
                System.out.print(cur.val + ", ");
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
    }

}
