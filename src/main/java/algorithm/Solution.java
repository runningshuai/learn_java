package algorithm;

import algorithm.linkedList.ListNode;
import java.util.*;
/**
 * @Description:
 * @Author: bsy
 * @Date: 2023/2/1 10:15
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode merge = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), Comparator.comparingInt(a -> a.val));

        for (ListNode node : lists) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            merge.next = poll;
            merge = merge.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return dummy.next;

    }
}
