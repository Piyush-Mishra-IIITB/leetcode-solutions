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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode h1=reverse(l1);
        ListNode h2=reverse(l2);
        ListNode temp=new ListNode(-1);
        ListNode ans=temp;
        while(h1!=null && h2!=null){
            int curr=h1.val+h2.val+carry;
            carry=curr/10;
            ListNode n=new ListNode(curr%10);
            temp.next=n;
            temp=temp.next;
            h1=h1.next;
            h2=h2.next;
        }
        while(h1!=null ){
            int curr=h1.val+carry;
            carry=curr/10;
            ListNode n=new ListNode(curr%10);
            temp.next=n;
            temp=temp.next;
            h1=h1.next;
        }
        while(h2!=null){
            int curr=h2.val+carry;
            carry=curr/10;
            ListNode n=new ListNode(curr%10);
            temp.next=n;
            temp=temp.next;
            h2=h2.next;
        }
        if(carry !=0){
            temp.next=new ListNode(carry);
        }
        return reverse(ans.next);
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