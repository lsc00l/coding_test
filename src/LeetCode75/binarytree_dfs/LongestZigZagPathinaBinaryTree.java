package LeetCode75.binarytree_dfs;
//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class LongestZigZagPathinaBinaryTree {
    public static void main(String[] args) {
        LongestZigZagPathinaBinaryTree l = new LongestZigZagPathinaBinaryTree();
        System.out.println(l.longestZigZag(new TreeNode(1, null, new TreeNode(1, new TreeNode(1), new TreeNode(1, new TreeNode(1, null, new TreeNode(1, null, new TreeNode(1))), new TreeNode(1))))));
        System.out.println(l.longestZigZag(new TreeNode(1, new TreeNode(1, null, new TreeNode(1, new TreeNode(1, null, new TreeNode(1)), new TreeNode(1))), new TreeNode(1))));
        System.out.println(l.longestZigZag(new TreeNode(1)));

    }
    public int longestZigZag(TreeNode root) {

        int answer = 0;
        answer = Math.max(answer,  dfs(root.left, 0, true));
        answer = Math.max(answer, dfs(root.right,  0, false));
        return answer;
    }

    public int dfs(TreeNode node, int cnt, boolean goLeft) {

        if(node == null) return cnt;
        cnt += 1;
        int max = cnt;

        if(goLeft) {
            max = Math.max(max, dfs(node.right, cnt, !goLeft));
            max = Math.max(max, dfs(node.left, 0, goLeft));
        }else { // goRight
            max = Math.max(max, dfs(node.left, cnt, !goLeft));
            max = Math.max(max, dfs(node.right, 0, goLeft));
        }

        return max;
    }
}
