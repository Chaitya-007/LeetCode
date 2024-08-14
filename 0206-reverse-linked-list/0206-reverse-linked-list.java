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

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = head;

        while(curr != null)
        {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
        
        // Brute Force
        // if(head == null)
        // {
        //     return head;
        // }

        // Stack<Integer> st = new Stack<Integer>();
        // ListNode ptr = head;
        // while(ptr != null)
        // {
        //     st.push(ptr.val);
        //     ptr = ptr.next;
        // }

        // ptr = head;

        // while(ptr != null)
        // {
        //     ptr.val = st.peek();
        //     st.pop();
        //     ptr = ptr.next;
        // }

        // return head;

        // Optimal 
        // if(head == null)
        // {
        //     return head;
        // }

        // ListNode curr = head;
        // ListNode forward = head;
        // ListNode prev = null;

        // while(curr != null)
        // {
        //     // Store for future
        //     forward = curr.next;
        //     // Reverse the link
        //     curr.next = prev;
        //     // Iterate the pointer
        //     prev = curr;
        //     curr = forward;
        // }

        // return prev;
    }
}