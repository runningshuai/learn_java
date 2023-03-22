package ds.sort.linkedListSeries;

public class ReverseList {
    /*
    反转链表，1、断 2、连 3、指针后移
     */
    public static ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        //cur一直扫到链表结尾，同时是反转链表的头
        while(cur != null){
            next = cur.next; //断
            cur.next = pre; //连
            pre = cur; //指针后移
            cur = next;
        }
        return pre;
    }

    /**l
     * 每两个反转链表
     * 注意单数和双数，单数不用反转，双数反转(可以控制双数进入反转)
     * https://mp.weixin.qq.com/s?__biz=MzIxNjc0ODExMA==&mid=2247486489&idx=1&sn=23b94f261ddc287c852df0452296cc92&scene=21#wechat_redirect
     * @param head
     * @return
     */
    public static ListNode reverseTwoList(ListNode head){
        ListNode yummy = new ListNode(0);
        yummy.next = head;
        head = yummy;
        //head.next.next !=null保证了后面至少有两个，才进入循环反转，也就是偶数反转
        //head.next != null && head.next.next =null是单数，不进入循环
        // 三条线断开与重新连上（需要一个前驱节点和一个后驱节点）
        while(head.next != null && head.next.next !=null){
            //循环内初始化
            ListNode a = head.next;
            ListNode b = a.next;

            //反转
            head.next = b;
            a.next = b.next;
            b.next = a;

            //移动指针
            head = a;
        }
        return yummy.next;

    }

    /**
     * 两两反转链表
     * 所有的变量都初始化好，不在循环内初始化变量，循环内只做指针移动
     * @param head
     * @return
     */
    public static ListNode reverseTwoList2(ListNode head){
        if(head ==null || head.next == null)return null;

        ListNode yummy = new ListNode(0);
        yummy.next = head;
        head = yummy;
        ListNode a;
        ListNode b;
        //head.next.next !=null保证了后面至少有两个，才进入循环反转，也就是偶数反转
        //head.next != null && head.next.next =null是单数，不进入循环
        //保证能移动的条件
        while(head.next != null && head.next.next !=null){
            //当下一个节点和下下节点都存在，指针才可以移动
            a = head.next;
            b = a.next;

            //反转
            head.next = b;
            a.next = b.next;
            b.next = a;

            //移动指针
            head = a;
        }
        return yummy.next;

    }

    public static ListNode reverseKList(ListNode head, int k){
        ListNode yummy = new ListNode(0);
        ListNode pre = yummy;
        yummy.next = head;
        head = yummy;
        ListNode a; //子链表的头节点
        ListNode b; //子链表的尾节点
        ListNode next; //待遍历的节点
        int i;

        while(head.next != null){
            i = 0;
            a = head.next;
            //找子链表的尾节点b
            while(head.next != null){
                i +=1;
                head = head.next;
                if(i==k) break;
            }
            b = head;
            next = b.next;
            b.next = null;

            if(i==k){
                b = reverseList(a);
                pre.next = b;
                a.next = next;
                pre = a;
                head = a;
            }else{
                return yummy.next;
            }
        }
        return yummy.next;
    }



    public static void main(String[] args) {
        int[] arr= new int[]{1,1,1,2,2,3,3,4};
        ListNode list1 = new ListNode(0);
        ListNode yummy=list1;
        yummy.next = list1;
        for(int i=0; i< arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            list1.next = node;
            list1 = list1.next;
        }

        ListNode list2 = yummy.next;
        ListNode listNode = reverseKList(list2, 4);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
