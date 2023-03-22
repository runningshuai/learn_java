package ds.sort.linkedListSeries;

/**
 * 返回倒数k个节点，只能遍历一次
 * 注意边界条件,当长度小于k时要考虑
 * 快慢指针。n - k + 1， n需要先遍历一遍这个数组，然后遍历第2遍n - k + 1；
 * 但题目要求只能遍历一次，一个指针需要遍历两遍，且是分开串行执行，
 * 那我用两个指针，虽然是遍历一遍，但遍历的总数是两遍。
 * 有点多线程的意思，但需要巧妙的设计两个指针的关系。
 */
public class FindKthToTail {
    public static ListNode findKthToTailNode(ListNode head, int k){
        if(head ==null || k<=0){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        //先走k步
        for(int i=0; i< k; i++){
            fast = fast.next;
            if(fast == null){
                return slow;
            }

        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        ListNode kthToTailNode = findKthToTailNode(list2, 10);

        while(kthToTailNode != null){
            System.out.println(kthToTailNode.val);
            kthToTailNode = kthToTailNode.next;
        }
    }
    }
