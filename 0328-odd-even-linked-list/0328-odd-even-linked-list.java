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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode evenHead = new ListNode(0,null);
        ListNode evenptr = evenHead;

        ListNode temp = head;
        ListNode prev = null;

        int cnt = 0;
        while(temp != null)
        {
            cnt++;
            if(cnt%2 == 0)
            {
                System.out.println(temp.val);
                System.out.println("count " + cnt);
                evenptr.next = new ListNode(temp.val,null);
                evenptr = evenptr.next;
                prev.next = temp.next;
                temp = prev.next;
            }
            else
            {
                prev = temp;
                temp = temp.next;
            }
        }

        prev.next = evenHead.next;
        return head;
    }
}