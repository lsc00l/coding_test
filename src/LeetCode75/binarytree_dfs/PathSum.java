package LeetCode75.binarytree_dfs;

import java.util.*;
import java.util.stream.Collectors;

public class PathSum {

    public static void main(String[] args) {
//3,3,1
        PathSum p = new PathSum();
        System.out.println(p.pathSum(new TreeNode(10,
                new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))),
                new TreeNode(-3, null, new TreeNode(11))), 8   )) ;
        System.out.println(p.pathSum(new TreeNode( 5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)), new TreeNode(4))), 22)) ;

        System.out.println(p.pathSum(new TreeNode(-2, null, new TreeNode(-3)),-5));

    }

    int target;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        if(root == null) return 0;
        return dfs(root, new ArrayList<>());

    }

    public int dfs(TreeNode root, List<Long> list){
        int cnt = 0;
        //list 각 값들에 root.val 더해주기(현재 path 까지의 누적합)
        list = list.stream().map(num -> num + root.val).collect(Collectors.toList());
        //list 에 root.val 추가
        list.add(Long.valueOf(root.val));

        //target과 같은 값 있으면 세주고
        cnt = (int) list.stream().filter(integer -> integer == target).count();

        if(root.left != null) cnt += dfs(root.left, list);
        if(root.right != null) cnt += dfs(root.right, list);

        return cnt;
    }

}
