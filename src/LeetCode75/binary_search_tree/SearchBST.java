package LeetCode75.binary_search_tree;

import com.sun.source.tree.Tree;

public class SearchBST {
    private static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) {
        SearchBST bst = new SearchBST();
        TreeNode answer = bst.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),  new TreeNode(7) ), 5);
        System.out.println(answer);
        answer = bst.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),  new TreeNode(7) ), 2);
        System.out.println(answer);

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode node = null;
        if(root.left != null) node = searchBST(root.left, val);
        if(node != null) return node;

        if(root.right != null) node = searchBST(root.right, val);
        return node;
    }

}
