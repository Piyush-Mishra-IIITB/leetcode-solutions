class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;

        while(temp != null){
            length++;
            temp = temp.next;
        }

        if(length == n){
            return head.next;
        }

        int no = length - n;

        ListNode temp2 = head;

        for(int i = 1; i < no; i++){
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;

        return head;
    }
}