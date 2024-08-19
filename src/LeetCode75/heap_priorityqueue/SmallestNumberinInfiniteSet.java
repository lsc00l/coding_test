package LeetCode75.heap_priorityqueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestNumberinInfiniteSet {
    public static void main(String[] args) {
        SmallestInfiniteSet s = new SmallestInfiniteSet();
        s.addBack(2);
        System.out.println(s.popSmallest());
    }



}
class SmallestInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> queue;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        queue = new PriorityQueue<>();
        int i=1;
        while(i<=1000){
            set.add(i);
            queue.add(i++);
        }
    }

    public int popSmallest() {
        Integer peek = queue.poll();
        set.remove(peek);
        return peek.intValue();
    }

    public void addBack(int num) {
        if(!set.contains(num)) {
            set.add(num);
            queue.add(num);
        }
    }
}