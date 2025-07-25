/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        {
            return null;
        }

        ListNode slow = headA;
        ListNode fast = headB;

        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;

            if(slow == fast)
            {
                return slow;
            }

            if(slow == null)
            {
                slow = headB;
            }
            if(fast == null)
            {
                fast = headA;
            }
        }

        return slow;
    }
}