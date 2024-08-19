package LeetCode75.binarytree_dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth m = new MaxDepth();
//        System.out.println(m.maxDepth(new TreeNode(1, new TreeNode(2),null)));
        System.out.println(m.maxDepth_my(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))) ));

    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return Math.max(lh, rh)+1;
    }

    public int maxDepth_my(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 1);
    }
    public int dfs(TreeNode node, int depth){
        int a = depth, b = depth;
        if(node.right != null) a = Math.max(a, dfs(node.right, depth + 1));
        if(node.left != null) b = Math.max(b, dfs(node.left, depth + 1));
        return Math.max(a, b);
    }
    public int dfs_old(TreeNode node, int depth, int max){
        if(node.right != null) max = dfs_old(node.right, depth + 1, max);
        if(node.left != null) max = dfs_old(node.left, depth + 1, max);
        return Math.max(max, depth);
    }


}
