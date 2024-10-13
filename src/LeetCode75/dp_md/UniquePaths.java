package LeetCode75.dp_md;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3, 7));//28
        System.out.println(u.uniquePaths(3, 2));//3

    }
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];

        int i=0;
        int j=0;
        for(i=0 ; i< m ; i++){
            for(j = 0 ; j< n ; j++){
                if(i>= 1 && j >= 1) {
                    map[i][j] = map[i][j-1] + map[i-1][j];

                } else {
                    map[i][j] = 1;

                }


            }
        }

        return map[m-1][n-1];
    }
}
