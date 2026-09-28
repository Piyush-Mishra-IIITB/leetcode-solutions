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
    public ListNode doubleIt(ListNode head) {
        
        ListNode head2=reverse(head);
        ListNode temp=head2;
        int carry=0;
        ListNode ans=new ListNode(-1);
        ListNode var=ans;
        while(temp!=null){
             int currVal=temp.val;
             int value=currVal*2+carry;
             int toAdd=value%10;
             carry=value/10;
             var.next=new ListNode(toAdd);
             var=var.next;
             temp=temp.next;

        }
        if(carry!=0){
            var.next=new ListNode(carry);
        }
        return reverse(ans.next);
    }
    public ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;

        }
        return prev;
    }
}