package tree;

import java.util.*;

public class CreateBinaryTreeFromDescriptions_2196 extends BaseTree {


    public static void main(String[] args) {
        int[][] desc = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode binaryTree = new CreateBinaryTreeFromDescriptions_2196().createBinaryTree(desc);
        System.out.println();
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> allNode = new HashSet<>();
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            allNode.add(parent);
            allNode.add(child);
        }
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean left = description[2] == 1;

            TreeNode node = nodes.computeIfAbsent(parent, k -> new TreeNode(k));
            TreeNode childNode = nodes.computeIfAbsent(child, k -> new TreeNode(k));
            if (left) {
                node.left = childNode;
            } else {
                node.right = childNode;
            }
            allNode.remove(child);
        }
        return nodes.get(new ArrayList<>(allNode).get(0));
    }
}
