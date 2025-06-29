class Node 
{
    Node[] links = new Node[26];
    int endsWith = 0;
    int countPrefix = 0;

    public boolean containsKey(char ch)
    {
        return (links[(ch - 'a')] != null);
    }

    public void put(char ch,Node node)
    {
        this.links[(ch - 'a')] = node;
    }

    public Node get(char ch)
    {
        return this.links[(ch - 'a')];
    }

    public void increasePrefix()
    {
        this.countPrefix++;
    }

    public void increaseEnd()
    {
        this.endsWith++;
    }

    public void deleteEnd()
    {
        this.endsWith--;
    }

    public void reducePrefix()
    {
        this.countPrefix--;
    }

    public int getEnd()
    {
        return this.endsWith;
    }

    public int getPrefix()
    {
        return this.countPrefix;
    }

}

class Trie {

    private static Node root;
    public Trie() {
        root = new Node();

    }

    public void insert(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++)
        {
            if(!node.containsKey(word.charAt(i)))
            {
                node.put(word.charAt(i), new Node());
                
            }

            node = node.get(word.charAt(i));
            node.increasePrefix();
        }

        node.increaseEnd();
        
    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for(int i = 0; i < word.length(); i++)
        {
            if(node.containsKey(word.charAt(i)))
            {
                node = node.get(word.charAt(i));
            }
            else
            {
                return 0;
            }
        }

        return node.getEnd();
        
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;

        for(int i = 0; i < prefix.length(); i++)
        {
            if(node.containsKey(prefix.charAt(i)))
            {
                node = node.get(prefix.charAt(i));
            }
            else 
            {
                return 0;
            }
        }

        return node.getPrefix();
        
    }

    public void erase(String word) {


        if(countWordsEqualTo(word) > 0)
        {
        Node node = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(node.containsKey(word.charAt(i)))
            {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            
        }
            node.deleteEnd();
        }
        
    }
}



class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        if (n < 2) {
            return ans; // all zeros
        }
        // compute lcp of each adjacent pair
        int[] lcp = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            lcp[i] = commonPrefixLen(words[i], words[i + 1]);
        }
        // prefix max and suffix max of lcp[]
        int[] preMax = new int[n - 1], sufMax = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            preMax[i] = (i == 0 ? lcp[i] : Math.max(preMax[i - 1], lcp[i]));
        }
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = (i == n - 2 ? lcp[i] : Math.max(sufMax[i + 1], lcp[i]));
        }
        // for each removal index k
        for (int k = 0; k < n; k++) {
            int leftMax = 0, rightMax = 0;
            // lcp[0..k-2]
            if (k - 2 >= 0) leftMax = preMax[k - 2];
            // lcp[k+1..n-2]
            if (k + 1 <= n - 2) rightMax = sufMax[k + 1];
            int best = Math.max(leftMax, rightMax);
            // if removal creates a new adjacent pair between k-1 and k+1
            if (k > 0 && k < n - 1) {
                int c = commonPrefixLen(words[k - 1], words[k + 1]);
                best = Math.max(best, c);
            }
            ans[k] = best;
        }
        return ans;
    }

    private int commonPrefixLen(String a, String b) {
        int m = Math.min(a.length(), b.length()), i = 0;
        while (i < m && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }
}