package LeetCode75.prefix_sum;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[] {1,2,3}));
        System.out.println(pivotIndex(new int[] {2,1,-1}));

    }
    public static int pivotIndex_my(int[] nums) {

        int[] right = nums.clone();

        //left sum 구하기
        for (int i = 0; i < nums.length; i++) {
            nums[i] += (i>0) ? nums[i-1] : 0;
        }
        //right sum 구하기
        for (int i =( nums.length-1); i >=0 ; i--) {
            right[i] += (i==(nums.length-1)) ? 0 : right[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==right[i]) return i;
        }

        return -1;
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
