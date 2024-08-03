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
    public ListNode reverseList(ListNode head) {
        
        if(head == null)
        {
            return head;
        }

        ListNode curr = head;
        ListNode forward = head;
        ListNode prev = null;

        while(curr != null)
        {
            // Store for future
            forward = curr.next;
            // Reverse the link
            curr.next = prev;
            // Iterate the pointer
            prev = curr;
            curr = forward;
        }

        return prev;
    }
}