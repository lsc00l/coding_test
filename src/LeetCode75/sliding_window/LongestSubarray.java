package LeetCode75.sliding_window;

import java.util.ArrayList;
import java.util.List;

public class LongestSubarray {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1}));//3
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));//5
        System.out.println(longestSubarray(new int[]{1,1,1}));//2

    }
    public static int longestSubarray(int[] nums) {
        //0인 인덱스를 저장할 리스트
        int[] zeroArr = new int[nums.length];
        int cnt =0;
        zeroArr[cnt++] = -1;//배열의 0번째 인덱스를 위해
        for(int i=0; i<nums.length ;i++){
            if(nums[i]==0) zeroArr[cnt++] = i;
        }
        zeroArr[cnt] = nums.length;//배열의 마지막 인덱스를 위해

        if(cnt==1) // nums에 0이 없다면 무조건 하나는 삭제해야하므로 "길이-1" 리턴
            return nums.length -1;

        int max = 0;
        for(int i=2; i<=cnt ; i++){
            max = Math.max (max, zeroArr[i] - zeroArr[i-2] - 2 );
        }
        return max;
    }
}
