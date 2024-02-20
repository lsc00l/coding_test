package LeetCode75.sliding_window;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//https://leetcode.com/problems/maximum-average-subarray-i/
public class FindMaxAverage {

    public static void main(String[] args) {
//        System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
        System.out.println(findMaxAverage(new int[] {0,4,0,3,2}, 1));//4
//        System.out.println(findMaxAverage(new int[] {5}, 1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            arr[i] = (i == 0) ? nums[i] : arr[i-1] + nums[i];
        }
        double sum = (double) arr[k-1] / k;
        for(int i=k ; i < arr.length ; i++){
            sum = Math.max(sum, (arr[i]-arr[i-k]) / (double) k);
        }
        return sum;
    }
}
