package LeetCode75.LinkedList;

public class OddEvenList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        OddEvenList o = new OddEvenList();
        o.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));

    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return  null;

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        while(even.next !=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
