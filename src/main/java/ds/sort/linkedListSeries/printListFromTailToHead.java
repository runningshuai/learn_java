package ds.sort.linkedListSeries;

import java.util.ArrayList;

/**
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）
 * 1、用栈，进栈，出栈就实现了倒叙
 * 2、递归，在归的时候收集，实现反转收集数据
 */
public class printListFromTailToHead {

    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printFromTailToHead(ListNode listNode) {
        print(result, listNode);
        return result;
    }

    void print(ArrayList<Integer> result,ListNode node){
        if(node == null){
            return;
        }
        print(result, node.next);
        result.add(node.val);
    }


}
