package programmers.dfs_bfs;

public class TargetNumber {
    public static void main(String[] args) {

        TargetNumber t = new TargetNumber();
        System.out.println(t.solution(new int[]{1, 1, 1, 1, 1}, 3));//5
        System.out.println(t.solution(new int[]{4, 1, 2, 1}, 4));//2

    }
    static int target = 0;
    static int[] numbers;

    public int solution(int[] numbers, int target) {

        this.target = target;
        this.numbers = numbers;


        return bfs(0, 0);
    }
    public int bfs(int sum, int idx){
        if(idx == numbers.length){
            if(sum == target) return 1;
            return 0;
        }

        return bfs(sum + numbers[idx], idx+1) + bfs(sum - numbers[idx], idx+1);
    }


}
