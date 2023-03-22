package ds.sort.treeSeries;

public class PreOrderCreateBTree {
    private static int[] tree = {1, 2, 0, 0 ,3 , 4, 0, 0};
    private static int i = 0;
    static TreeNode preOrderCreateBTree(){
        TreeNode bt = null;
        int s = tree[i++];
        if(s == 0) {
            return bt;
        }else {
            bt = new TreeNode(s);
            bt.left = preOrderCreateBTree();
            bt.right = preOrderCreateBTree();
            return bt;
        }
    }

    public static void main(String[] args) {
        preOrderCreateBTree();
    }
}
