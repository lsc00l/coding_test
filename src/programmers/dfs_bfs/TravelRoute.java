package programmers.dfs_bfs;

import java.util.*;

import static java.util.Collections.list;

public class TravelRoute {
    public static void main(String[] args) {
        TravelRoute t = new TravelRoute();
//        System.out.println(t.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));	//{"ICN", "JFK", "HND", "IAD"}
//        System.out.println(t.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));	//{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
        System.out.println(t.solution(new String[][] {{"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}})); ///{ICN, "A", "C", "A", "B", "D"}
//        System.out.println(t.solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}));
//        System.out.println(t.solution(new String[][] {{"ICN", "BOO"}, {"BOO", "COO"}, {"COO", "ICN"}, {"ICN", "BOO"}, {"BOO", "COO"}, {"COO", "ICN"}}));
//        System.out.println(t.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }

    List<String> answer = new ArrayList<>();
    boolean check[];
    public String[] solution(String[][] tickets) {
        check = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);
        answer.sort(Comparator.naturalOrder());
        return answer.get(0).split(" ");

    }
    public void dfs(String destination, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){
            answer.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(destination.equals(tickets[i][0]) && !check[i]){
                check[i] = true;
                dfs(tickets[i][1],route+" "+tickets[i][1], tickets, cnt+1);
                check[i] = false;
            }
        }
    }


}











