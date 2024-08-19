package LeetCode75.heap_priorityqueue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumSubsequenceScore {
    public static void main(String[] args) {
        MaximumSubsequenceScore m = new MaximumSubsequenceScore();

        System.out.println(m.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3));
    }

    int[] arr1;
    int[] arr2;
    int K;
    public long maxScore(int[] nums1, int[] nums2, int k) {
        arr1 = nums1;
        arr2 = nums2;
        K = k;


        return dfs(new HashSet<>(), 0, 0,Integer.MAX_VALUE);
    }

    public long dfs(Set<Integer> chk, int idx, int a, int b){


        if(chk.size() == K) {
            System.out.println(chk);
            System.out.println("a=" + a + " b=" + b + " a*b=" + a*b);
            return a*b;
        }
        long answer = 0;
        for(int i=idx; i < arr1.length ; i++){

            if(chk.size()==0 && i > arr1.length-K){
                return answer;
            }

            if(!chk.contains(i)){
                a = a + arr1[idx];
                chk.add(i);
                answer = Math.max(answer, dfs(chk, i+1, a + arr1[idx],Math.min(arr2[idx], b)));
                chk.remove(idx);
            }

        }

        return answer;
    }
}
