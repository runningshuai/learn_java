package algorithm.linkedList.two;

import algorithm.linkedList.ListNode;

/**
 * @Description: 合并两个有序链表
 * @Author: bsy
 * @Date: 2022/12/1 1:08
 */
public class MergeTwoLists {

    ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode merge = new ListNode(-1);

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                merge.next = list1;
                list1 = list1.next;
            }else{
                merge.next = list2;
                list2 = list2.next;
            }
            // 指针向前推进，数组不用，链表容易忘
            merge = merge.next;
        }

        if(list1 == null){
            merge.next = list2;
        }

        if(list2 == null){
            merge.next = list1;
        }

        return merge.next;
    }
}
