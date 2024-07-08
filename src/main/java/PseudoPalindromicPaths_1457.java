import java.util.Stack;

public class PseudoPalindromicPaths_1457 {

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(3, null, null), new TreeNode(1, null, null)),
                new TreeNode(1, null, new TreeNode(1)));
        int i = new PseudoPalindromicPaths_1457().dfs(root);
        System.out.println(i);
    }

    public int dfs(TreeNode root) {
        int rs = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> historyNodes = new Stack<>();
        int[] counts = new int[10];
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            historyNodes.push(node);
            counts[node.val]++;
            boolean isLeaf = node.left == null && node.right == null;
            if (isLeaf) {
                boolean isPalindrom = isPalindrom(counts);
                rs += (isPalindrom ? 1 : 0);
                historyNodes.pop();
                counts[node.val]--;
                if (!stack.empty()) {
                    TreeNode top = stack.peek();
                    while (!historyNodes.empty()) {
                        TreeNode history = historyNodes.peek();
                        boolean isHasParent = history.left == top || history.right == top;
                        if (isHasParent) {
                            break;
                        }
                        counts[history.val]--;
                        historyNodes.pop();
                    }
                }
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return rs;
    }

    public int pseudoPalindromicPaths(TreeNode root, int[] rs) {
        rs[root.val]++;
        int t = 0;
        if (root.left == null && root.right == null) {
            // for(int i : rs){
            //     System.out.print(i + "\t");
            // }
            // System.out.println();
            return isPalindrom(rs) ? 1 : 0;
        }

        if (root.left != null) {
            t += pseudoPalindromicPaths(root.left, rs);
            rs[root.left.val]--;
        }
        if (root.right != null) {
            t += pseudoPalindromicPaths(root.right, rs);
            rs[root.right.val]--;
        }
        return t;
    }

    public boolean isPalindrom(int[] rs) {
        int maxOdd = 0;
        for (int r : rs) {
            if (r % 2 == 1) {
                maxOdd++;
            }
        }
        return maxOdd <= 1;
    }
}
