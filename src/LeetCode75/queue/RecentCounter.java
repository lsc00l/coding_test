package LeetCode75.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    public static void main(String[] args) {
        RecentCounter r = new RecentCounter();
        System.out.println(r.ping(1));
        System.out.println(r.ping(100));
        System.out.println(r.ping(3001));
        System.out.println(r.ping(3002));
    }

    LinkedList<Integer> list;
    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);
        while(list.getFirst() < t-3000){
            list.pollFirst();
        }
        return list.size();
    }

}
