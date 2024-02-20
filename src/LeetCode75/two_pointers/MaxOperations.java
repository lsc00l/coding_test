package LeetCode75.two_pointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxOperations {
    public static void main(String[] args) {

        System.out.println(maxOperations(new int[] {1,2,3,4}, 5));
        System.out.println(maxOperations(new int[] {3,1,3,4,3}, 6));
    }
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int answer =  0;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum == k) {
                answer++;
                left++;
                right--;
            }
            else if (sum > k) right--;
            else if (sum < k) left++;
        }
        return answer;
    }
}
