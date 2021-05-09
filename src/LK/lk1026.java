package LK;

/**
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 */
public class lk1026 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        lk1026 lk = new lk1026();
        lk.maxAncestorDiff(treeNode);
        System.out.println(lk.max);
    }

    int max;

    public int maxAncestorDiff(TreeNode root) {
        if(root.left == null && root.right == null)
            return 0;
        if(root.left != null)
            maxAncestorDiff(root.left);
        if(root.right != null)
            maxAncestorDiff(root.right);

        mathRoot(root,root.val);
        return max;
    }

    private void mathRoot(TreeNode root,int val) {
        if(root.left != null)
            mathRoot(root.left,val);
        if(root.right != null)
            mathRoot(root.right,val);
        if(max < Math.abs(val-root.val))
            max = Math.abs(val-root.val);
    }


}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

