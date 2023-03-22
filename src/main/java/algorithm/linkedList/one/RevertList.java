package algorithm.linkedList.one;

import algorithm.linkedList.BuildLinkedList;
import algorithm.linkedList.ListNode;

/**
 * @Description: 单链表反转
 * @Author: bsy
 * @Date: 2022/11/30 11:27
 */
public class RevertList {

    public ListNode revertLinkedList(ListNode head){
        if(head == null ||  head.next == null) {
            return head;
        }

        ListNode pre= head;
        head=head.next;
        ListNode next;
        // 第一个要断开，不然会一直和第2个节点相连，就会形成环
        pre.next = null;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode revertLinkedListV2(ListNode head){
        if(head == null) {
            return null;
        }
        // 增加一个前置节点
        ListNode pre= null;
        ListNode next;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public ListNode reverse (ListNode head){
        if(head==null||head.next==null){return head;}
        ListNode pre=null;
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildDemoLinkedList();
        RevertList revertList = new RevertList();

        ListNode cur = revertList.revertLinkedListV2(demoList);
        while (cur != null){
            if(cur.next != null){
                System.out.print(cur.val + ", ");
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }
        //只有一个节点，内部的head，但值不变
        cur = demoList;
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
