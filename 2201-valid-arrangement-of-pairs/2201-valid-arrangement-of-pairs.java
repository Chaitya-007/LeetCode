class Solution {
    public int[][] validArrangement(int[][] pairs){
        Map<Integer, Stack<Integer>> g = new HashMap<>();
        Map<Integer, Integer> out = new HashMap<>();
        for(int[] p : pairs){
            g.putIfAbsent(p[0], new Stack<>());
            g.get(p[0]).add(p[1]);
            out.put(p[0], out.getOrDefault(p[0], 0) + 1);
            out.put(p[1], out.getOrDefault(p[1], 0) - 1);
        }
        int start = out.keySet().stream().filter(k -> out.get(k) == 1).findFirst().orElse(pairs[0][0]);
        LinkedList<int[]> r = new LinkedList<>();
        arrange(start, g, r);
        return r.toArray(new int[0][]);
    }

    void arrange(int u, Map<Integer, Stack<Integer>> g, LinkedList<int[]> r){
        for(Stack<Integer> s = g.getOrDefault(u, null); s != null && !s.isEmpty(); ){
            Integer v = s.pop();
            arrange(v, g, r);
            r.addFirst(new int[]{u, v});
        }
    }
}