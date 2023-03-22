package algorithm.linkedList.one;

import algorithm.linkedList.BuildLinkedList;
import algorithm.linkedList.ListNode;

/**
 * @Description: 反转m,n之间的链表
 * @Author: bsy
 * @Date: 2023/1/29 17:54
 */
public class RevertBetween {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        int i=0;
        ListNode a=null,c=null;
        while(cur !=null){
            if(i==m-1){
                a = cur;
            }
            if(i==n){
                c = cur;
                break;
            }
            cur = cur.next;
            i+=1;
        }
        ListNode b = a.next;
        ListNode d = c.next;
        c.next=null;
        a.next=null;
        reverse(b);
        a.next = c;
        b.next = d;
        return dummy.next;

    }

    public void reverse (ListNode head){
        if(head==null||head.next==null){return;}
        ListNode pre=null;
        ListNode cur = head;
        ListNode next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur=next;
        }
    }
    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildDemoLinkedList();
        RevertBetween revert = new RevertBetween();

        ListNode cur = revert.reverseBetween(demoList,1, 2);
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
