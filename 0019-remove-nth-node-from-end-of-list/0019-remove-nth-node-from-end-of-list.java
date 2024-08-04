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
        if(head == null)
        {
            return head;
        }

        

        ListNode newHead = reverseList(head);

        if(n == 1)
        {
            newHead = newHead.next;
            head = reverseList(newHead);
            return head;
        }

        ListNode ptr = newHead;
        ListNode prev = null;
        int cnt = 0;
        while(ptr != null)
        {
            cnt++;
            if(cnt == n)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = ptr;
            ptr = ptr.next;

        }

        head = reverseList(newHead);
        return head;
    }
}