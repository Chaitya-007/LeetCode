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
    public ListNode reverseList(ListNode head)
    {
        // Brute Force
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode curr = head;
        ListNode forward = head;
        ListNode prev = null;

        while(curr != null)
        {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Optimal Solution
        if(head == null)
        {
            return head;
        }

        ListNode fast = head;
        for(int i = 0; i < n; i++)
        {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        if(fast == null)
        {
            return head.next;
        }

        slow.next = slow.next.next;

        return head;

        // Brute Force
        // if(head == null)
        // {
        //     return head;
        // }

        // ListNode fast = head;
        // int cnt = 0;
        // while(fast != null)
        // {
        //     cnt++;
        //     fast  = fast.next;
        // }

        // int result = (cnt - n);

        // if(result == 0)
        // {
        //     return head.next;
        // }

        // fast = head;
        // while(fast != null)
        // {
        //     result--;
        //     if(result == 0)
        //     {
        //         // System.out.println(fast.val);
        //         fast.next = fast.next.next;
        //         break;
        //     }
        //     fast = fast.next;
        // }

        // return head;



        // Mine
        // if(head == null)
        // {
        //     return head;
        // }

        

        // ListNode newHead = reverseList(head);

        // if(n == 1)
        // {
        //     newHead = newHead.next;
        //     head = reverseList(newHead);
        //     return head;
        // }

        // ListNode ptr = newHead;
        // ListNode prev = null;
        // int cnt = 0;
        // while(ptr != null)
        // {
        //     cnt++;
        //     if(cnt == n)
        //     {
        //         prev.next = prev.next.next;
        //         break;
        //     }
        //     prev = ptr;
        //     ptr = ptr.next;

        // }

        // head = reverseList(newHead);
        // return head;
    }
}