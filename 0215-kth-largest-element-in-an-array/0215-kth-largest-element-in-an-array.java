class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int val : nums)
        {
            pq.offer(val);
        }

        int res = k - 1;
        while(res > 0)
        {
            pq.poll();
            res--;
        }

        return pq.peek();
    }
}