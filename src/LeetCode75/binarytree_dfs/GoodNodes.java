package LeetCode75.binarytree_dfs;

public class GoodNodes {

    public static void main(String[] args) {
        GoodNodes m = new GoodNodes();
        System.out.println(m.goodNodes( new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5))) ));
    }

    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, 0, root.val);
    }

    private int dfs(TreeNode root, int cnt, int max) {
        if(root.val >= max) {
            cnt++;
            max = root.val;
        }
        if(root.left != null) cnt = dfs(root.left, cnt, max);
        if(root.right != null) cnt = dfs(root.right, cnt, max);
        return cnt;
    }
}
