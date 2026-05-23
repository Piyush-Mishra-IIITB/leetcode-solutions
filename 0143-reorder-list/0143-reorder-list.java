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
    public void reorderList(ListNode head) {
      ListNode mid=middle(head);
      ListNode temp2=reverse(mid.next);
      mid.next=null;
      ListNode temp1=head;
      while(temp1!=null && temp2!=null){
        ListNode t1=temp1.next;
        ListNode t2=temp2.next;
        temp1.next=temp2;
        temp2.next=t1;
        temp1=t1;
        temp2=t2;
      }
    
    }
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){

        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode n=curr.next;
            curr.next=prev;
            prev=curr;
            curr=n;
        }
        return prev;
    }
}