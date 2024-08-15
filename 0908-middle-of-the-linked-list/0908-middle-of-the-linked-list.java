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

    public int countNodes(ListNode head)
    {
        int cnt = 0;
        ListNode ptr = head;
        while(ptr != null)
        {
            cnt++;
            ptr = ptr.next;
        }

        return cnt;
    }

    public ListNode middleNode(ListNode head) {

        if(head == null) 
        {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

        // Brute Force
        // int n = countNodes(head);
        // int position = (n/2) + 1;

        // ListNode temp = head;

        // while(temp != null)
        // {
        //     position--;
        //     if(position == 0)
        //     {
        //         break;
        //     }

        //     temp = temp.next;
        // }

        // return temp;

        // Optimal
        // if(head == null)
        // {
        //     return null;
        // }

        // ListNode slow = head;
        // ListNode fast = head;

        // while(fast != null && fast.next != null)
        // {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }

        // return slow;

    }
}