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
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1);
        ListNode big=new ListNode(-1);
        ListNode q=small;
        ListNode p=big;
        ListNode t=head;
        while(t!=null){
            int curr=t.val;
            if(curr<x){
                small.next=t;
                small=small.next;
            }
            else{
              big.next=t;
              big=big.next;
            }
            t=t.next;
        }
        big.next=null;
        small.next=p.next;
        return q.next;

    }
}