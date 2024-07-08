package tree;

public class BTSToGreaterSumTree_1038 {

    public TreeNode bstToGst(TreeNode root) {
        int val = 0;
        if (root.right != null) {
            val = browseRight(root.right, 0);
        }
        root.val += val;
        if (root.left != null) {
            browseRight(root.left, root.val);
        }
        return root;
    }

    int browseRight(TreeNode node, int totalRight) {
        int val = node.val;
        if (node.right != null) {
            val += browseRight(node.right, totalRight);
        }
        node.val = val + totalRight;
        int sumLeft = 0;
        if (node.left != null) {
            sumLeft += browseRight(node.left, node.val);
        }
        return val + sumLeft;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
