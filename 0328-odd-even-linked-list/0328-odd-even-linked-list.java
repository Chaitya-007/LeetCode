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

        // Optimal Solution
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while(even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;

        // Brute Force
        // if(head == null || head.next == null)
        // {
        //     return head;
        // }
        // ArrayList<Integer> list = new ArrayList<Integer>();
        // // for odd positon
        // ListNode fast = head;
        // while(fast != null && fast.next != null)
        // {
        //     list.add(fast.val);
        //     fast = fast.next.next;
        // }
        // if(fast != null)
        // {
        //     list.add(fast.val);
        // }

        // // for even position
        // fast = head.next;
        // while(fast != null && fast.next != null)
        // {
        //     list.add(fast.val);
        //     fast = fast.next.next;
        // }
        // if(fast != null)
        // {
        //     list.add(fast.val);
        // }

        // fast = head;
        // int i = 0;
        // while(fast != null)
        // {
        //     fast.val = list.get(i);
        //     i++;
        //     fast = fast.next;
        // }

        // return head;


        // Self solution
        // if(head == null || head.next == null)
        // {
        //     return head;
        // }

        // ListNode evenHead = new ListNode(0,null);
        // ListNode evenptr = evenHead;

        // ListNode temp = head;
        // ListNode prev = null;

        // int cnt = 0;
        // while(temp != null)
        // {
        //     cnt++;
        //     if(cnt%2 == 0)
        //     {
        //         evenptr.next = new ListNode(temp.val,null);
        //         evenptr = evenptr.next;
        //         prev.next = temp.next;
        //         temp = prev.next;
        //     }
        //     else
        //     {
        //         prev = temp;
        //         temp = temp.next;
        //     }
        // }

        // prev.next = evenHead.next;
        // return head;
    }
}