package LeetCode75.dp_1d;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10,15,20})); // 15
        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1})); // 6
    }

    public int minCostClimbingStairs(int[] cost) {

        int N = cost.length;

        for(int i = 2 ; i < N ; i++){
            cost[i] += (cost[i-1] <= cost[i-2]) ? cost[i-1] : cost[i-2];

        }

        return Math.min(cost[N-1],cost[N-2]);
    }


}
