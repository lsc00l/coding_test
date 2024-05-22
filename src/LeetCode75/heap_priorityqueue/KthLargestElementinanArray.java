package LeetCode75.heap_priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthLargestElementinanArray {
    public static void main(String[] args) {
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4},2));//5
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));//4
        System.out.println(k.findKthLargest(new int[]{99,99},1));//4
    }

    public int findKthLargest(int[] nums, int k) {

        Integer[] numArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numArr, Collections.reverseOrder());
        for(int i=0; i< nums.length; i++){
            if(i+1 == k)
                return numArr[i];
        }

        return 0;
    }

}
