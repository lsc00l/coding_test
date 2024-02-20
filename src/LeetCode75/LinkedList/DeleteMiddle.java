package LeetCode75.LinkedList;

import java.util.Objects;

public class DeleteMiddle {
    public static void main(String[] args) {

        DeleteMiddle d = new DeleteMiddle();
        ListNode ln = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(d.deleteMiddle(ln));
    }

    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteMiddle2(ListNode head) {
        if(head.next == null) return null;
        int cnt =0;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next!=null){
            cnt++;
            p1 = p1.next;
        }
        cnt = (int) (Math.ceil((double)cnt/2.0) -1);

        for(int i=0; i<cnt ;i++){
            p2 = p2.next;
        }
        p2.next= p2.next.next;

        return head;
    }

    /**
     * fast and slow 로직을 사용
     *
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        ListNode slow = head, fast = head.next.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;//한 노드씩
            fast = fast.next.next;//두 노드씩 이동
        }
        slow.next = slow.next.next;
        return head;
    }
}
