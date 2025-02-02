class Solution {

    public int f(String s,char A, char B, int k)
    {
        int dis = 0;
        int maxDis = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == A || ch == B) // if character is our desired direction
            {
                dis++;
            }
            else // if the character is not of our desired direction
            {
                if(k > 0)
                {
                    k--;
                    dis++;
                }
                else
                {
                    dis--;
                }
         
            }

            maxDis = Math.max(maxDis, dis);
        }

        return maxDis;
    }


    public int maxDistance(String s, int k) {
        int ans = 0;
        ans = Math.max(f(s,'N','E',k), ans);
        ans = Math.max(f(s,'N','W',k), ans);
        ans = Math.max(f(s,'S','E',k), ans);
        ans = Math.max(f(s,'S','W',k), ans);

        return ans;
        
    }
}