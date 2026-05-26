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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer>ss=new Stack<>();
        int len=length(head);
        ListNode t=reverse(head);
        ss.push(t.val);
        t=t.next;
        while(t!=null){
            int curr=t.val;
            if(curr>=ss.peek()){
                ss.push(curr);
            }
            
            t=t.next;
        }
        ListNode tem=new ListNode(-1);
        ListNode p=tem;
        while(!ss.isEmpty()){
          ListNode c=new ListNode(ss.pop());
          tem.next=c;
          tem=tem.next;
        }
        return p.next;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode tm=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tm;
        }
        return prev;
    }
    public int length(ListNode head){
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
}