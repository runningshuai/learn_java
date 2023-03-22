package ds.sort.treeSeries;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 之字型打印二叉树：也就是分偶数和奇数层打印，其打印方向相反
 * 双栈法：一个存奇数层，一个存偶数层
 * 怎么标识层数，一个栈的元素全部弹出，即遍历完一层，层数+1
 */
public class PrintTree {

    public ArrayList<ArrayList<Integer>> printTree(TreeNode root){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> stack1 = new Stack<>(); // 奇数行，进栈先右后左
        Stack<TreeNode> stack2 = new Stack<>(); // 偶数行，进栈先左后右
        stack1.add(root);
        int i=1;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(i%2 !=0){
                //奇数行，本行从左向右遍历，进栈先右后左，下一行相反，进栈先左后右
                ArrayList<Integer> tmp = new ArrayList<>();
                while(!stack1.isEmpty()){
                    TreeNode pop = stack1.pop();
                    tmp.add(pop.val);
                    if(pop.left != null )stack2.push(pop.left);
                    if(pop.right != null )stack2.push(pop.right);
                }
                i+=1;
                result.add(tmp);
            }else{
                //偶数行，本行从右向左遍历，进栈先左后右，下一行相反，进栈先右后左
                ArrayList<Integer> tmp = new ArrayList<>();
                while(!stack2.isEmpty()){
                    TreeNode pop = stack2.pop();
                    tmp.add(pop.val);
                    if(pop.right != null )stack1.push(pop.right);
                    if(pop.left != null )stack1.push(pop.left);
                }
                result.add(tmp);
                i +=1;
            }
        }
        return result;
    }
}
