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

    public ListNode collisionPoint(ListNode small, ListNode large, int diff)
    {
        while(diff > 0)
        {
            diff--;
            large = large.next;
        }

        while(small != large)
        {
            small = small.next;
            large = large.next;
        }

        return small; // or return large
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Naive Approach
        // T.C -> O(n1 * logN) + O(n2 * logN)
        // S.C -> O(N1) or O(N2)
        // if(headA == null && headB == null)
        // {
        //     return null;
        // }

        // HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();

        // ListNode ptra = headA;
        // ListNode ptrb = headB;

        // while(ptra != null)
        // {
        //     map.put(ptra,1);
        //     ptra = ptra.next;
        // }

        // while(ptrb != null)
        // {
        //     if(map.containsKey(ptrb))
        //     {
        //         return ptrb;
        //     }
        //     ptrb = ptrb.next;
        // }

        // return null;

        // Using Two Approach
        if(headA == null && headB == null)
        {
            return null;
        }
        int n1 = 0;
        int n2 = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != null)
        {
            n1++;
            tempA = tempA.next;
        }

        while(tempB != null)
        {
            n2++;
            tempB = tempB.next;
        }

        tempA = headA; // Set the pointers to head again
        tempB = headB; // Set the pointers to head again

        if(n1 < n2)
        {
            return collisionPoint(tempA,tempB,n2 - n1);
        }

        return collisionPoint(tempB,tempA,n1 - n2);
    }
}