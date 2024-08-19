package LeetCode75.graphs_dfs;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms k = new KeysAndRooms();
        //[[1],[2],[3],[]]
        List<List<Integer>> rooms = new ArrayList<>();
//        rooms.add(new ArrayList<>(Arrays.asList(1)));
//        rooms.add(new ArrayList<>(Arrays.asList(2)));
//        rooms.add(new ArrayList<>(Arrays.asList(3)));
//        rooms.add(new ArrayList<>());
//        System.out.println(k.canVisitAllRooms(rooms)); //true
//
//        rooms.clear();
//        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
//        rooms.add(new ArrayList<>(Arrays.asList(3, 0, 1)));
//        rooms.add(new ArrayList<>(Arrays.asList(2)));
//        rooms.add(new ArrayList<>(Arrays.asList(0)));
//        System.out.println(k.canVisitAllRooms(rooms));

        rooms.clear();
        rooms.add(new ArrayList<>(Arrays.asList(2, 3)));
        rooms.add(new ArrayList<>( ));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(1, 3)));
        System.out.println(k.canVisitAllRooms(rooms));  // true

        rooms.clear();
        rooms.add(new ArrayList<>(Arrays.asList(1,7,9))); // 0
        rooms.add(new ArrayList<>(Arrays.asList(8,3,6))); // 1
        rooms.add(new ArrayList<>(Arrays.asList(1))); // 2
        rooms.add(new ArrayList<>(Arrays.asList(6,5))); // 3
        rooms.add(new ArrayList<>(Arrays.asList(4,7))); // 4
        rooms.add(new ArrayList<>(Arrays.asList(5,2,6))); // 5
        rooms.add(new ArrayList<>(Arrays.asList(4,5))); // 6
        rooms.add(new ArrayList<>(Arrays.asList(2))); // 7
        rooms.add(new ArrayList<>(Arrays.asList(9,8,2,3,4))); //8
        rooms.add(new ArrayList<>(Arrays.asList(1,3,9))); // 9
        System.out.println(k.canVisitAllRooms(rooms)); //true

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] chk = new boolean[rooms.size()];
        Set<Integer> visited = new HashSet<>();
        dfs(visited, rooms, 0);
        return (visited.size() == rooms.size()) ? true :false;
    }


    public void dfs (Set<Integer> visited, List<List<Integer>> rooms, int room) {

        visited.add(room);
        List<Integer> keys = rooms.get(room);

        for(Integer k : keys){
            if(visited.contains(k))continue;
            dfs(visited, rooms, k);
        }
    }
}
