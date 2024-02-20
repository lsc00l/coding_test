package LeetCode75.hashmap_set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1,2,3}, new  int[]{2,4,6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new  int[]{1,1,2,2}));

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        set1.removeAll(intersection);
        set2.removeAll(intersection);

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(set1));
        answer.add(new ArrayList<>(set2));
        return answer;
    }

}
