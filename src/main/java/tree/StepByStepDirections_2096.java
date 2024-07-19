package tree;

public class StepByStepDirections_2096 extends BaseTree {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (startValue == destValue) {
            return "";
        }
        TreeNode node = root;
        Boolean hasStart = Boolean.FALSE;
        Boolean hasDest = Boolean.FALSE;
        if (node.val == startValue) {
            hasStart = Boolean.TRUE;

        }
        if (node.val == destValue) {
            hasStart = Boolean.TRUE;
        }
        while (node != null) {

        }
        return "";
    }

    private void find(TreeNode node, int start, int dest, Boolean startNode, Boolean destNode) {
        if (node == null) {
            return;
        }
        if (node.val == start) {
            startNode = Boolean.TRUE;
        }
        if (node.val == dest) {
            destNode = Boolean.TRUE;
        }
        find(node.left, start, dest, startNode, destNode);
        find(node.right, start, dest, startNode, destNode);
    }
}
