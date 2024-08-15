/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

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

            if(slow == fast) 
            {
                fast = head;
                while(slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                    return slow;
            }
        }

        return null;

        // Optimal Solution
        // T.c -> O(N)
        // S.C -> O(1)

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

        //     if(slow == fast)
        //     {
        //         slow = head;

        //         while(slow != fast)
        //         {
        //             slow = slow.next;
        //             fast = fast.next;
        //         }

        //         return slow;
        //     }
        // }

        // return null;

        // Brute Force
        // T.C -> O(N*logn)
        // S.C -> O(N)
        // if(head == null)
        // {
        //     return null;
        // }

        // HashMap<ListNode, Integer> map = new HashMap<ListNode,Integer>();
        // int ind = 0;

        // ListNode temp = head;
        // while(temp != null)
        // {
        //     if(map.containsKey(temp))
        //     {
        //         return temp;
        //     }
        //     map.put(temp,ind);
        //     ind++;
        //     temp = temp.next;
        // }

        // return null;
    }
}