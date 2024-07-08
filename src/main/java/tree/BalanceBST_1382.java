package tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST_1382 extends BaseTree {
    private List<TreeNode> sortedLst = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedLst.size() - 1);
    }

    private void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedLst.add(root);
        inorderTraverse(root.right);
    }

    private TreeNode sortedArrayToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = sortedLst.get(mid);
        root.left = sortedArrayToBST(start, mid - 1);
        root.right = sortedArrayToBST(mid + 1, end);
        return root;
    }

}
