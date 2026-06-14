/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class Solution {
    public int pairSum(ListNode head) {

        int len = length(head);
        int n = len / 2;

        ListNode temp = head;

        for(int i = 1; i < n; i++) {
            temp = temp.next;
        }
        ListNode second = temp.next;
        temp.next = null;
        second = reverse(second);
        int max = 0;
        ListNode p1 = head;
        ListNode p2 = second;
        while(p2 != null) {
            max = Math.max(max, p1.val + p2.val);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
    }
    public int length(ListNode head) {
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}