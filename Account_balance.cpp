// https://leetcode.com/contest/biweekly-contest-110/problems/account-balance-after-rounded-purchase/

class Solution {
public:
    int accountBalanceAfterPurchase(int purchaseAmount) {
        int res;
        int rem;
        int roundoff;
        rem = purchaseAmount%10;
        if(rem >= 5)
        {
            roundoff = purchaseAmount + (10 - rem);
            res = 100 - roundoff;
            return res;
        }
        else
        {
            roundoff = purchaseAmount - rem;
            res = 100 - roundoff;
            return res;
        }
    }
};
