class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null)
            return head;
        int length = 1;
        ListNode last = head;

        while (last.next != null) {
            length++;
            last = last.next;
        }

        k = k % length;

        if (k == 0)
            return head;

        int move = length - k;

        ListNode tail = head;

        for (int i = 1; i < move; i++) {
            tail = tail.next;
        }

        ListNode newHead = tail.next;

        last.next = head;
        tail.next = null;

        return newHead;
    }
}