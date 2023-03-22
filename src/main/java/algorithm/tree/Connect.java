package algorithm.tree;

/**
 * @Description: 填充节点的右侧指针
 * @Author: bsy
 * @Date: 2022/11/29 17:53
 */
public class Connect {

    /**
     * 传入两个根节点，构造三叉树
     * @return 解题方法来自labuladong
     */
    Node connect(Node root){
        if(root == null){
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return;
        }
        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        traverse(node1.right, node2.left);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node next=null;

}

