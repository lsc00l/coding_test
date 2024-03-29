package programmers.dfs_bfs;

import java.util.*;

public class TravelRoute {
    public static void main(String[] args) {
        TravelRoute t = new TravelRoute();
        System.out.println(t.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));	//{"ICN", "JFK", "HND", "IAD"}
        System.out.println(t.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));	//{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}
        System.out.println(t.solution(new String[][] {{"ICN","A"},{"A","B"},{"A","C"},{"C","A"},{"B","D"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "BOO"}, {"BOO", "COO"}, {"COO", "ICN"}, {"ICN", "BOO"}, {"BOO", "COO"}, {"COO", "ICN"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}, {"AAA", "HND"}, {"JFK", "AAA"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA","ICN"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "AAA"}, {"ICN", "BBB"}, {"BBB", "CCC"}, {"AAA", "DDD"}, {"DDD", "EEE"}, {"CCC", "ICN"}}));
        System.out.println(t.solution(new String[][] {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}}));
    }
    static int ticketsNum ;
    public List<String> solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            PriorityQueue<String> list = map.getOrDefault(ticket[0], new PriorityQueue<>());
            list.offer(ticket[1]);
            map.put(ticket[0], list);
        }
        ticketsNum = tickets.length;
        return dfs(map, tickets[0][0],new ArrayList<>());
    }

    public List<String> dfs(Map<String, PriorityQueue<String>> map, String from, List<String> answer){
        answer.add(from);
        if(!map.containsKey(from) || answer.size() == ticketsNum + 1){
            return answer;
        }

        while(!map.get(from).isEmpty()) {
            String to = map.get(from).poll();

            List<String> answer2 = dfs(map, to, answer);
            if(answer2.size() == ticketsNum + 1)
                return answer2;
        }
        return answer;
    }
}











