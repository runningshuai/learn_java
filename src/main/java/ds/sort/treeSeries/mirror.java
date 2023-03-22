package ds.sort.treeSeries;

//操作给定的二叉树，将其变换为源二叉树的镜像。
public class mirror {

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null) return pRoot;
        //递，建立镜像树
        TreeNode tmp;
        tmp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tmp;

        Mirror(pRoot.left);
        Mirror(pRoot.right);
        // 没有用到归的结果，在递的过程就完成了镜像
        return pRoot;

    }

}
