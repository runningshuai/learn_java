package algorithm.linkedList.one;

import algorithm.linkedList.BuildLinkedList;
import algorithm.linkedList.ListNode;

/**
 * @Description: 反转k组链表，先找k组，然后反转，最后连接
 * https://juejin.cn/post/6844903986558926856
 * @Author: bsy
 * @Date: 2022/11/30 17:42
 */
public class RevertKGroupList {

    ListNode revertKGroupList(ListNode head, int k){
        if(head == null || k <=0){
            return null;
        }

        ListNode yummy = new ListNode(-1);
        yummy.next = head;

        ListNode pre = yummy;
        ListNode end = yummy;

        while(end.next != null){

            for(int i=0; i<k && end != null; i++){
                end = end.next;
            }
            //不足k个，不用反转
            if(end==null){
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;

            pre.next = revertList(start);
            start.next = next;

            pre = start;
            end = start;
        }

        return yummy.next;

    }

    ListNode revertList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre=null;
        ListNode next;

        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        ListNode dummy=new ListNode(-1);
        dummy.next = head;

        ListNode cur=dummy;
        ListNode pre=dummy;

        while(cur.next != null){
            for(int i=0; i<k&&cur!=null; i++){
                cur = cur.next;
            }
            //最后阶段不满足k个,不需要反转
            if(cur==null){
                return dummy.next;
            }

            ListNode start = pre.next;
            ListNode next = cur.next;
            cur.next=null;

            pre.next = reverse(start);
            start.next = next;

            pre = start;
            cur = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){return head;}

        ListNode pre = new ListNode(-1);

        while(head !=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildDemoLinkedList();
        RevertKGroupList revertList = new RevertKGroupList();
        ListNode cur = revertList.revertKGroupList(demoList, 3);

        while (cur != null){
            if(cur.next != null){
                System.out.print(cur.val + ", ");
            }else{
                System.out.print(cur.val);
            }
            cur = cur.next;
        }

        ListNode demoList2 = buildLinkedList.buildDemoLinkedList();
        ListNode listNode = revertList.reverseKGroup(demoList2, 3);

        cur = listNode;
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
