package LeetCode75.binarytree_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
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
    }

    public static void main(String[] args) {


    }
    public static int maxLevelSum(TreeNode root) {
        int answer = 0;
        int level = 1;
        int max = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            int sum = 0;
            for(int i=0 ; i< cnt ; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(max < sum){
                max = sum;
                answer = level;
            }
            level++;
        }

        return answer;
    }
}