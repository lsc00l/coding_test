package LeetCode75.two_pointers;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
//        moveZeroes(new int[] {0,0,1});//1,0,0
    }
    public static void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i=0 ; i< nums.length ; i++){
            if(nums[i] != 0){
                nums[idx++] = nums[i];
            }
        }
        for(int i =idx ; i< nums.length ; i++){
            nums[idx++] = 0;
        }
        System.out.println();
    }
}
