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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        int carry = 0;
        ListNode head = temp;

        
        while(l1 != null && l2 != null)
        {
            int sum = (l1.val) + (l2.val) + carry;
            carry = sum/10;
            int nodeVal = (sum%10);
            temp.next = new ListNode(nodeVal);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null)
        {
            int sum = (l1.val) + carry;
            carry = sum/10;
            int nodeVal = (sum%10);
            temp.next = new ListNode(nodeVal);
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null)
        {
            int sum = (l2.val) + carry;
            carry = sum/10;
            int nodeVal = (sum%10);
            temp.next = new ListNode(nodeVal);
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry == 1)
        {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }

        return head.next;
        

    }
}