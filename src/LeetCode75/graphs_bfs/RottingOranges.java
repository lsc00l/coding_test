package LeetCode75.graphs_bfs;

public class RottingOranges {
    public static void main(String[] args) {

        RottingOranges r = new RottingOranges();
        System.out.println(r.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}})); //4
        System.out.println(r.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}})); //-1
        System.out.println(r.orangesRotting(new int[][]{{0,2}}));//0
    }




    int[][] map;
    public int orangesRotting(int[][] grid) {

        map = new int[grid.length + 2][grid[0].length +2];

        boolean fresh = false;
        for(int i=0 ; i<grid.length ; i++){
            for(int j=0; j < grid[0].length ; j++){
                map[i+1][j+1] = grid[i][j];
                if(grid[i][j] == 1) fresh = true;
            }
        }
        if(!fresh) return 0;

        return bfs(1, true, 2);
    }


    public int bfs(int cnt, boolean fresh, int rot) {
        if(cnt > map.length* map[0].length) return -1;
        for(int i=1 ; i<map.length -1 ; i++) {
            for(int j=1 ; j < map[0].length -1 ; j++){
                if(map[i][j] == rot){
                    if(map[i-1][j] > 0) map[i-1][j] = rot + 2;
                    if(map[i+1][j] > 0) map[i+1][j] = rot + 2;
                    if(map[i][j-1] > 0) map[i][j-1] = rot + 2;
                    if(map[i][j+1] > 0) map[i][j+1] = rot + 2;

                } else if (map[i][j] == 1){
                    fresh = true;
                }
            }
        }
        if(fresh) {
            int result = bfs(cnt, false, rot+2);
            cnt = (result == -1) ? -1 : cnt +result;

        }

        return cnt;
    }

}














