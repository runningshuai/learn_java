package LeetCode;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //哨兵节点prehead,这容易让我们得到合并之后的链表
        ListNode prehead = new ListNode(-1);

        //一直往后扩展的尾节点
        ListNode prev = prehead;

        while(l1 != null && l2!= null){
            if(l1.val < l2.val){
                prev.next=l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if(l1 == null){
            prev.next = l2;
        }else{
            prev.next = l1;
        }
        //头节点是-1，要返回后面的
        return prehead.next;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {this.val=val;}
    ListNode(int val, ListNode next){this.val=val;this.next=next;}

}
