package programmers.dfs_bfs;

public class PickupItems {

    public static void main(String[] args) {

        PickupItems p = new PickupItems();


        System.out.println(p.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8));	//17
//        System.out.println(p.solution(new int[][] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, 9, 7, 6, 1));	//11
//        System.out.println(p.solution(new int[][] {{1,1,5,7}}, 1, 1, 4, 7));	//9
//        System.out.println(p.solution(new int[][] {{2,1,7,5},{6,4,10,10}}, 3, 1, 7, 10));	//15
    }


    int sx, sy, ex, ey;
    int[][] map = new int[102][102];
    boolean[][] chkMap = new boolean[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        sx = characterX * 2;
        sy = characterY * 2;
        ex = itemX * 2;
        ey = itemY * 2;


        /* 1. map에 주어진 사각형 영역을 -1 로 채운다. */
        for(int[] r : rectangle){
            for(int x=r[0]*2; x<=r[2]*2; x++){
                for(int y=r[1]*2; y<= r[3]*2; y++){
                    map[x][y] = -1;
                }
            }
        }

        /* 2. 지뢰찾기 하듯이.. chkMap 에 테두리만 부분만 true 로 남긴다. */
        for(int i=1 ; i< 101 ; i++){
            for(int j=1; j < 101 ; j++){
                if(map[i][j] != -1)continue;
                if(map[i-1][j-1] + map[i-1][j] + map[i-1][j+1] + map[i][j-1] + map[i][j+1] + map[i+1][j-1] + map[i+1][j] + map[i+1][j+1] > -8){
                    chkMap[i][j] = true;
                }
            }
        }

        bfs(sx, sy, 0);

        /*4. map 에서 목적지 cnt 가져오기 나누기 2하면 답 */
        return map[ex][ey] /2;
    }


    public void bfs(int x, int y, int cnt){

        if(map[x][y] == -1){
            map[x][y] = cnt;
        } else{


            map[x][y] = Math.min(map[x][y], cnt);
        }
        if(x==ex && y==ey ) {

            return;
        }
        /* 3. 테두리를 따라 갈 수 있는 방향으로 계속 간다. */
        // 목적지를 제외하고 한번 간 곳은 가지 않는다.
        if((x-1 == ex && y == ey) || (chkMap[x-1][y] && map[x-1][y] == -1)) bfs(x-1, y, cnt + 1);
        if((x+1 == ex && y == ey) || (chkMap[x+1][y] && map[x+1][y] == -1)) bfs(x+1, y, cnt + 1);
        if((x == ex && y-1 == ey) || (chkMap[x][y-1] && map[x][y-1] == -1)) bfs(x, y-1, cnt + 1);
        if((x == ex && y+1 == ey) || (chkMap[x][y+1] && map[x][y+1] == -1)) bfs(x, y+1, cnt + 1);

    }
}