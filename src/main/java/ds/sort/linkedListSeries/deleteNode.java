package ds.sort.linkedListSeries;

/**
 * 删除链表中值为val的节点
 * 如果要删除的节点是第一个，需要特殊处理
 * 遍历的时候需要指定cur节点，为了连接后面的节点需要保存cur的前驱节点
 * pre和cur要前后错开，指针移动时从前往后，依次移动
 */
public class deleteNode {
    public static ListNode deleteNodeByValue(ListNode head, int val){

        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val==val){
                if(cur==head)return head.next;
                pre.next = cur.next;
                cur.next = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode listNode = deleteNodeByValue(list1, 5);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
