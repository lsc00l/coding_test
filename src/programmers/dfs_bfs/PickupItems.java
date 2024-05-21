package programmers.dfs_bfs;

import java.util.Arrays;

public class PickupItems {

    public static void main(String[] args) {

        PickupItems p = new PickupItems();

//        System.out.println(p.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}}, 1, 3, 7, 8));	//17
//        System.out.println(p.solution(new int[][] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}}, 9, 7, 6, 1));	//11
        System.out.println(p.solution(new int[][] {{1,1,5,7}}, 1, 1, 4, 7));	//9
//        System.out.println(p.solution(new int[][] {{2,1,7,5},{6,4,10,10}}, 3, 1, 7, 10));	//15
    }

    int ix;
    int iy;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = new int[50][50];

        for(int[] r : rectangle){
            for(int x=r[0]; x<=r[2]; x++){
                for(int y=r[1]; y<= r[3]; y++){
                    map[x][y] = -1;
                }
            }

        }

        map[characterX][characterY] = 1;

        ix=itemX;
        iy=itemY;


        return dfs(map, characterX, characterY, 0);
    }

    public int dfs(int[][] rectangle, int cx, int cy, int cnt){

        System.out.println(cx + ", " + cy);
        rectangle[cx][cy] = 0;

        if(cx == ix && cy == iy) {
            return cnt;
        }

        int max = Integer.MAX_VALUE;

        if(rectangle[cx+1][cy] < 0){
            int rectangle2[][] = new int[50][50];
            for (int i = 0; i < rectangle.length; i++) {
                System.arraycopy(rectangle[i], 0, rectangle2[i], 0, rectangle[i].length);
            }
            max = Math.min(max, dfs(rectangle2, cx+1, cy, cnt+1));
        }
        if(rectangle[cx][cy+1] < 0){
            int rectangle2[][] = new int[50][50];
            for (int i = 0; i < rectangle.length; i++) {
                System.arraycopy(rectangle[i], 0, rectangle2[i], 0, rectangle[i].length);
            }
            max = Math.min(max, dfs(rectangle2, cx, cy+1, cnt+1));
        }
        if(rectangle[cx-1][cy] < 0){
            int rectangle2[][] = new int[50][50];
            for (int i = 0; i < rectangle.length; i++) {
                System.arraycopy(rectangle[i], 0, rectangle2[i], 0, rectangle[i].length);
            }

            max = Math.min(max, dfs(rectangle2, cx-1, cy, cnt+1));
        }
        if(rectangle[cx][cy-1] < 0){
            int rectangle2[][] = new int[50][50];
            for (int i = 0; i < rectangle.length; i++) {
                System.arraycopy(rectangle[i], 0, rectangle2[i], 0, rectangle[i].length);
            }
            max = Math.min(max, dfs(rectangle2, cx, cy-1, cnt+1));
        }

        return max;
    }



}












