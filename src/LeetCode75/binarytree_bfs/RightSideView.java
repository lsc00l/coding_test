package LeetCode75.binarytree_bfs;

import java.util.*;

public class RightSideView {

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
        RightSideView r = new RightSideView();

        System.out.println(r.rightSideView(new TreeNode(1, new TreeNode(2, null,new TreeNode(5)), new TreeNode(3,null,new TreeNode(4)))));
        System.out.println(r.rightSideView(new TreeNode(1, new TreeNode(2),null)));
        System.out.println(r.rightSideView(new TreeNode(1, new TreeNode(2, new TreeNode(4),null),new TreeNode(3))));

    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cnt = queue.size();
            for(int i=0; i< cnt ; i++){
                TreeNode node = queue.poll();
                if(i == cnt - 1){
                    list.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return list;
    }



    public List<Integer> answer(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 현재 레벨에서 가장 오른쪽에 있는 노드의 값을 결과에 추가합니다.
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // 왼쪽과 오른쪽 자식들을 큐에 추가합니다.
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;

    }
}
