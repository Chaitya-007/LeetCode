class Solution {

    Map<String, Integer> mpp = new HashMap<>();
    String b;
    List<List<String>> ans = new ArrayList<>();

    public void dfs(String word, List<String> seq)
    {
        if(word.equals(b))
        {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }

        int steps = mpp.get(word);
        int sz = word.length();

        for(int i = 0; i < sz; i++)
        {
                StringBuilder temp = new StringBuilder(word);
            
            for(char ch = 'a' ; ch <= 'z'; ch++)
            {
                temp.setCharAt(i,ch);
                if(mpp.containsKey(temp.toString()) && mpp.get(temp.toString()) + 1 == steps)
                {
                    seq.add(temp.toString());
                    dfs(temp.toString(),seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<String>();

        for(String str : wordList)
        {
            set.add(str);
        }


        if(!set.contains(endWord)) return ans;

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        
        // Since we have added beginWord in queue therefore remove it from set
        set.remove(beginWord);

        mpp.put(beginWord,1);

        b = beginWord;

        int len = beginWord.length();

        while(!q.isEmpty())
        {
            String word = q.peek();
            int level = mpp.get(word);
            q.poll();

            
            if(word.equals(endWord)) break;

            for(int i = 0; i < len; i++)
            {
                StringBuilder temp = new StringBuilder(word);

                for(char ch = 'a'; ch <= 'z'; ch++)
                {
                    temp.setCharAt(i,ch);

                    if(set.contains(temp.toString()))
                    {
                        
                        StringBuilder sb = new StringBuilder(temp.toString());
                        q.offer(sb.toString());
                        mpp.put(sb.toString(),level+1);
                        set.remove(temp.toString());
                    }
                }
            }
        }

        if(mpp.containsKey(endWord))
        {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }

        return ans;


    }
}