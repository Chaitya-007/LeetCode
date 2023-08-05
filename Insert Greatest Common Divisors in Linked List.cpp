// https://leetcode.com/contest/biweekly-contest-110/problems/insert-greatest-common-divisors-in-linked-list/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        struct ListNode *p;
        struct ListNode *q;
        p = head;
        q = head;
        long int count = 0;
        int gcd;
         int m,n;
        
        
         while(p != NULL)
        {
            count++;
            p = p -> next;
        }
            p = head;
        
        if(count == 1)
        {
            return head;
        }
        
        else
        {
            p = p->next;
            while (p != NULL)
            {
                
                m = q -> val;
                n = p -> val;
               while(m != n)
                    {
                        if(m > n)
                        {
                            m = m - n;
                        }
                        else
                        {
                            n = n - m;
                        }
                    }
                gcd = m;
                struct ListNode *t = new ListNode();
                t -> val = gcd;
                t -> next = q -> next;
                q -> next = t;
                
                q = p;
                p = p->next;
                
            }
            return head;
        }
        
        
        
    }
};
