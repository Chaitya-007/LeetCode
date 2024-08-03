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

    public static boolean checkPallindrome(ArrayList<Integer> list)
    {
        int n = list.size();
        
        int left = 0;
        int right = n - 1;

        while(left < right)
        {
            if(list.get(left) != list.get(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public ListNode reverseHead(ListNode head)
    {
        ListNode curr = head;
        ListNode forward = head;
        ListNode prev = null;

        while(curr != null)
        {
            forward = forward.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }

   

    public boolean isPalindrome(ListNode head) {

        // Optimal 
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverseHead(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second != null)
        {
            if(first.val != second.val)
            {
                reverseHead(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseHead(newHead);
        return true;

        // Brute Force - 1
        // ArrayList<Integer> list = new ArrayList<Integer>();

        // ListNode ptr = head;
        // while(ptr != null)
        // {
        //     list.add(ptr.val);
        //     ptr = ptr.next;
        // }


        // if(checkPallindrome(list))
        // {
        //     return true;
        // }

        // return false;

        // Brute Force 2
        // Stack<Integer> st = new Stack<Integer>();
        // ListNode temp = head;

        // if(head.next == null)
        // {
        //     return true;
        // }

        // while(temp != null)
        // {
        //     st.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;
        // while(temp != null)
        // {
        //     if(temp.val != st.peek())
        //     {
        //         return false;
        //     }

        //     temp = temp.next;
        //     st.pop();
        // }

        // return true;
        
    }
}