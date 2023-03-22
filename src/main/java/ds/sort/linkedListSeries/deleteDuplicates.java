package ds.sort.linkedListSeries;

public class deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head){
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val!=pre.val){
                //承担移动和移走重复元素的作用
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next; //只提供遍历
        }
        pre.next = null; //最后一个要处理
        return head;
    }

    public static void main(String[] args) {
        int[] arr= new int[]{1,1,2,2,3,3};
        ListNode list1 = new ListNode(0);
        ListNode yummy=list1;
        yummy.next = list1;
        for(int i=0; i< arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            list1.next = node;
            list1 = list1.next;
        }

        ListNode list2 = yummy.next;
        ListNode listNode = deleteDuplicates(list2);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
