package LeetCode75.dp_1d;

public class TribonacciNumber {
    public static void main(String[] args) {

        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));

    }
    static int tribonacci(int n) {
        int[] tribonacci = new int[38];
        tribonacci[0] = 0;
        tribonacci[1] = 1;
        tribonacci[2] = 1;

        for(int i=0 ; i<=n ; i++){
            if(i>=3){
                tribonacci[i] = tribonacci[i-1] + tribonacci[i-2] + tribonacci[i-3];
            }
        }

        return tribonacci[n];
    }
}
