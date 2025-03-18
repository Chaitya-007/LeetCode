class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // Build a list of conflict pairs grouped by their left endpoint.
        List<List<Pair<Integer, Integer>>> conflictByLeft = new ArrayList<>(n + 1);
        
        for(int i = 0; i <= n; i++) {
            conflictByLeft.add(new ArrayList<>());
            
        }
        
        int m = conflictingPairs.length;
        int k = 0;
        while (k < m) {
            int a = conflictingPairs[k][0];
            int b = conflictingPairs[k][1];
            int L = Math.min(a, b);
            int R = Math.max(a, b);
            conflictByLeft.get(L).add(new Pair<>(R, k));
            k++;
        }
        
        // Use a TreeSet to keep active conflict pairs' right endpoints.
        TreeSet<Pair<Integer, Integer>> activeSet = new TreeSet<>((p1,p2) -> 
        {
            if(p1.getKey() == p2.getKey())
            {
                return Integer.compare(p1.getValue(),p2.getValue());
            }

            return Integer.compare(p1.getKey(),p2.getKey());
        });
        // cnt[r] counts the number of conflict pairs with right endpoint r currently active.
        List<Integer> cnt = new ArrayList<>(n + 1);
       
        for(int i = 0; i <= n; i++)
         {
            cnt.add(0);
        }
        
        long base = 0;
        List<Long> improvements = new ArrayList<>(m);
        for(int i = 0; i < m; i++)
        {
            improvements.add((long)0);
        }
        // Process positions from n down to 1.
       
        for(int i = n; i >= 1; i--)
        {
            // Add all conflict pairs that start at pos.
            for(Pair<Integer, Integer> p : conflictByLeft.get(i))
            {
                activeSet.add(p);
                int R = p.getKey();
                cnt.set(R,cnt.get(R) + 1);
            }
            
            if (activeSet.isEmpty()) {
                base += (long) (n + 1 - i);
            } 
            else {
                Pair<Integer,Integer> p = activeSet.first();
                int minR = p.getKey();
                base += (minR - i);
                
                // If the smallest right endpoint appears only once, we can remove its conflict to improve.
                if (cnt.get(minR) == 1) {
                    int k_i = activeSet.first().getValue();
                    Pair<Integer,Integer> secMin = activeSet.higher(p);
                    int secMinR = (secMin == null) ? n + 1 : secMin.getKey();
                    improvements.set(k_i, improvements.get(k_i) + secMinR - minR);
                }
            }
           
        }
        
        long maxo = 0;

        for(Long val : improvements)
        {
            maxo = Math.max(maxo,val);
        }

        return base + maxo;
    }
}

