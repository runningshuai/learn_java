package algorithm.tree.constructTree;

import algorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @Description: 从前序和中序构建二叉树
 * @Author: bsy
 * @Date: 2022/11/29 23:54
 */
public class ConstructFromPreorderAndInorder {

    HashMap<Integer, Integer> valueToIndex = new HashMap<>();

    TreeNode constructFromPreorderAndInorder(int[] preOrder, int[] inOrder){
        for(int i=0; i< inOrder.length; i++){
            valueToIndex.put(inOrder[i], i);
        }
        return build(preOrder, 0, preOrder.length -1,
                inOrder, 0, inOrder.length -1);

    }

    TreeNode build(int[] preOrder, int preStart, int preEnd,
               int[] inorder, int inStart, int inEnd){
        //bad case
        if(preStart > preEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);
        int rootIndex = valueToIndex.get(preOrder[preStart]);
        int leftSize = rootIndex - inStart;
        root.left = build(preOrder, preStart + 1,  preStart + leftSize,
                inorder, inStart, rootIndex -1);

        root.right = build(preOrder, preStart + leftSize +1,  preEnd,
                inorder, rootIndex + 1, inEnd);
        return root;


    }
}
