package algorithm.linkedList.one;

import algorithm.linkedList.BuildLinkedList;
import algorithm.linkedList.ListNode;

/**
 * @Description: 每两个一组反转链表;操作两个指针
 * https://juejin.cn/post/6844903969362280456
 * @Author: bsy
 * @Date: 2022/11/30 16:04
 */
public class RevertTwoGroupList {

    ListNode revertTwoGroupList(ListNode head){
        //bad case
        if(head == null || head.next==null){
            return head;
        }
        ListNode yummy = new ListNode(-1);
        yummy.next = head;
        head = yummy;
        ListNode a;
        ListNode b;

        while((head.next != null)&&(head.next.next != null)){
            a = head.next;
            b = a.next;

            head.next = b;
            a.next = b.next;
            b.next = a;

            // dummy 指针前移
            head = a;
        }

        return yummy.next;
    }

    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildDemoLinkedList();
        RevertTwoGroupList revertList = new RevertTwoGroupList();

        ListNode cur = revertList.revertTwoGroupList(demoList);
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
