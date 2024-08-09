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

    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(left != null && right != null)
        {
            if(left.val <= right.val)
            {
                temp.next = left;
                temp = left;
                left = left.next;
            }
            else
            {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        if(left != null) temp.next = left;
        else temp.next = right;

        return dummyNode.next;
    }

    public ListNode getMiddle(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);
        ListNode result = merge(leftHead,rightHead);
        return result;
    }
}