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
    public ListNode deleteMiddle(ListNode head) {

        // Brute 
        if(head == null || head.next == null)
        {
            return null;
        }
        int size = 0;
        ListNode ptr = head;
        while(ptr != null)
        {
            size++;
            ptr = ptr.next;
        }

        size = size/2;

        ptr = head;
        while(ptr != null)
        {
            size--;
            if(size == 0)
            {
                ptr.next = ptr.next.next;
                break;
            }
            ptr = ptr.next;
        }

        return head;


        // Mine 2
        // if(head == null || head.next == null)
        // {
        //     return null;
        // }

        // ListNode slow = head;
        // ListNode fast = head;
        // ListNode prev = null;

        // while(fast != null && fast.next != null)
        // {
        //     prev = slow;
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // prev.next = prev.next.next;
        // return head;



        // Optimal
        // T.C -> O(N/2)
        // S.C -> O(1)
        // if(head == null || head.next == null)
        // {
        //     return null;
        // }

        // ListNode fast = head;
        // ListNode slow = head;

        // fast = fast.next.next; // Skip one step

        // while(fast != null && fast.next != null)
        // {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // slow.next = slow.next.next;
        // return head;
        
    }
}