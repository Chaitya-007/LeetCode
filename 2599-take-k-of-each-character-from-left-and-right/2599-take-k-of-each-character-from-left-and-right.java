class Solution {
    public int takeCharacters(String s, int k) {
     

        int cnta = 0, cntb = 0, cntc = 0;

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            

            if(ch == 'a') cnta++;
            if(ch == 'b') cntb++;
            if(ch == 'c') cntc++;

        }
         

        int l = 0;
        int r = 0;
        int n = s.length();
        int notdelted = 0;

        if(cnta < k || cntb < k || cntc < k)
        {
            return -1;
        }

        while(r < n)
        {
            char ch = s.charAt(r);
            if(ch == 'a') cnta--;
            if(ch == 'b') cntb--;
            if(ch == 'c') cntc--;

            while(l <= r && (cnta < k || cntb < k || cntc < k))
            {
             ch = s.charAt(l);
            if(ch == 'a') cnta++;
            if(ch == 'b') cntb++;
            if(ch == 'c') cntc++;
            l++;

            }
         notdelted = Math.max(notdelted, r - l + 1);
         r++;
            
        }

  

        
        return n - notdelted;

    }
}