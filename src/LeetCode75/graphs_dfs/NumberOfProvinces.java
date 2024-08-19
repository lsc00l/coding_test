package LeetCode75.graphs_dfs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        System.out.println(n.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));//2
        System.out.println(n.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));//0

    }

    int[][] map;
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int answer = 0;

        map = isConnected;

        for(int i=0 ; i< isConnected.length ; i++){
            if( !visited.contains(i) ){
                dfs(visited, i);
                answer++;
            }
        }

        return answer;
    }
    public void dfs(Set<Integer> visited, int idx){

        visited.add(idx);

        for(int i = 0; i< map.length ; i++) {
            if(idx != i && map[idx][i]==1 && ! visited.contains(i)){
                dfs(visited, i);
            }
        }
    }
}
