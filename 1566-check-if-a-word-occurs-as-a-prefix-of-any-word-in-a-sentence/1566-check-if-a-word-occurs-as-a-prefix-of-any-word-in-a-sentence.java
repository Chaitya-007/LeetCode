class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int start = 0;
        int cnt = 0;
        for(int i = 0; i < sentence.length(); i++)
        {
            char ch = sentence.charAt(i);
            if(ch == ' ')
            {
                cnt++;
                String str = sentence.substring(start,i);
                if(str.startsWith(searchWord))
                {
                    return cnt;
                }
                start = i + 1;
            }
        }
        cnt++;
                String str = sentence.substring(start,sentence.length());
                if(str.startsWith(searchWord))
                {
                    return cnt;
                }

                return -1;


    }
}