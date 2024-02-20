package LeetCode75.sliding_window;

public class LongestOnes {
    public static void main(String[] args) {

        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(longestOnes(new int[]{0,0,0,1}, 4));

    }
    public static int longestOnes_my(int[] nums, int k) {
        int max=0, sum =0;
        int[] zeroArr = new int[nums.length+1];
        int zeroIdx=0;
        for(int i=0; i < nums.length ; i++){
            if(nums[i] == 0) zeroArr[zeroIdx++] = i;
        }
        zeroArr[zeroIdx++] = nums.length;
        if(zeroIdx-1  < k) k = zeroIdx-1;
        for(int i=k; i < zeroIdx ; i++){
            int a = zeroArr[i]-1;
            int b = (i-k == 0) ? 0 : zeroArr[i-k-1]+1;
            sum = a - b + 1;
            max = Math.max(max, sum);
        }
        return max;
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) k--;

            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }


        }

        return right - left;
    }



}
