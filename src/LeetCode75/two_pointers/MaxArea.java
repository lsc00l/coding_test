package LeetCode75.two_pointers;

import java.util.Arrays;

public class MaxArea {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));//49
        System.out.println(maxArea(new int[]{4,3,2,1,4}));//16
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while(left < right){
            answer = Math.max(answer, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right]) right--;
            else if(height[left] < height[right]) left++;
            else{
                right--;
                left++;
            }
        }
        return answer;
    }

}
