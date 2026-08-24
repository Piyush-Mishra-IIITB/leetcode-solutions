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
        ListNode temp1=l1;
        ListNode temp2=l2;
        int carry=0;
        ListNode op=new ListNode(-1);
        ListNode var=op;
        while(temp1!=null && temp2!=null){
            if(carry==0){
                int val1=temp1.val+temp2.val;
                carry=val1/10;
                ListNode newOne=new ListNode(val1%10);
                var.next=newOne;
                var=var.next;
                temp1=temp1.next;
                temp2=temp2.next;
            }else{
                int val1=temp1.val+temp2.val+carry;
                carry=val1/10;
                ListNode newOne=new ListNode(val1%10);
                var.next=newOne;
                var=var.next;
                temp1=temp1.next;
                temp2=temp2.next;
            }
        }
        while(temp1!=null){
             int val1=temp1.val+carry;
                carry=val1/10;
                ListNode newOne=new ListNode(val1%10);
                var.next=newOne;
                var=var.next;
                temp1=temp1.next;
        }
        while(temp2!=null){
             int val1=temp2.val+carry;
                carry=val1/10;
                ListNode newOne=new ListNode(val1%10);
                var.next=newOne;
                var=var.next;
                temp2=temp2.next;
        }
        if(carry!=0){
            ListNode c= new ListNode(carry);
            var.next=c;
            var=var.next;
        }
        return op.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}