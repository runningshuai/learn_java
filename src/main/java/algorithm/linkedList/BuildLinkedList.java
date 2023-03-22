package algorithm.linkedList;

/**
 * @Description:
 * @Author: bsy
 * @Date: 2022/11/30 10:47
 */
public class BuildLinkedList {

    public ListNode buildDemoLinkedList(){
        int[] nums = {2, 3, 4, 5, 6, 7, 8};

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int item: nums){
            cur.next = new ListNode(item);
            cur = cur.next;
        }

        return head;
    }

    public ListNode buildRandomLinkedList(){
        int[] nums = {2, 8, 5, 3, 10, 4, 7};

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int item: nums){
            cur.next = new ListNode(item);
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode demoList = buildLinkedList.buildDemoLinkedList();

        ListNode cur = demoList.next;
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
