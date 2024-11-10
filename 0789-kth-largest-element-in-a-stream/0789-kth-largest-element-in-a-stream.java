class KthLargest {
    List<Integer> list = new ArrayList<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums)
        {
            list.add(i);
        }
        
    }
    
    public int add(int val) {
        list.add(val);

        Collections.sort(list);
        int n = list.size();
       

        return list.get(n-(this.k));
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */