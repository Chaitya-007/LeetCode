class Pair
{
    String str;
    int step;

    public Pair(String str_, int step_)
    {
        this.str = str_;
        this.step = step_;
    }

    public String getString()
    {
        return str;
    }

    public int getStep()
    {
        return step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int listSize = wordList.size();

        HashSet<String> set = new HashSet<>();

        for(String str : wordList)
        {
            set.add(str);
        }

        if(!set.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();

        // int ans = 0;

        int len = beginWord.length();

        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty())
        {
            StringBuilder str = new StringBuilder(q.peek().getString());
            int step = q.peek().getStep();
            // ans = Math.max(ans,step);
            q.poll();

            for(int i = 0; i < len; i++)
            {
            StringBuilder sb = new StringBuilder(str.toString());
                
                for(char ch = 'a' ; ch <= 'z'; ch++)
                {
                    sb.setCharAt(i,ch);
                    if(set.contains(sb.toString()))
                    {
                        q.offer(new Pair(sb.toString(), step + 1));
                        set.remove(sb.toString());
                        if(sb.toString().equals(endWord))
                        {
                            return step + 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}