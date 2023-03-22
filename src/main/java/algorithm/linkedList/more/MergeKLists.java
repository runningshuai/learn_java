package algorithm.linkedList.more;

import algorithm.linkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 合并k个链表
 * @Author: bsy
 * @Date: 2022/12/1 1:55
 */
public class MergeKLists {

    ListNode mergeKLists(ListNode[] lists){
        // bad case
        if(lists == null){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        for(ListNode node:listNodes){
            if(node != null){
                listNodes.add(node);
            }
        }
        while(!listNodes.isEmpty()){
            ListNode poll = listNodes.poll();
            p.next = poll;
            if(poll.next != null) {
                listNodes.add(poll.next);
            }
            p=p.next;
        }
        return dummy.next;
    }
}
