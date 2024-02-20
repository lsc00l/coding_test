package LeetCode75.prefix_sum;

public class LargestAltitude {
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[] {-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[] {52,-91,72}));
        System.out.println(largestAltitude(new int[] {-4,-3,-2,-1,4,3,2}));
    }
    public static int largestAltitude(int[] gain) {
        int max = Math.max(0, gain[0]);
        for(int i=1; i<gain.length ; i++){
            gain[i] += gain[i-1];
            max = Math.max(max, gain[i]);
        }
        return max;
    }


}
