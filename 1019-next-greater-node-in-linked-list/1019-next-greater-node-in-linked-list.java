/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */class Solution {

    public int[] nextLargerNodes(ListNode head) {

        int n = 0;

        ListNode temp = head;

        while(temp != null){
            n++;
            temp = temp.next;
        }

        int[] arr = new int[n];

        temp = head;

        int index = 0;

        while(temp != null){
            arr[index++] = temp.val;
            temp = temp.next;
        }

        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){

            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }
}