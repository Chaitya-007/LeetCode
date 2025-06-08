class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        
        // Try to make all elements equal to 1
        int opsToMakeAll1 = countOperations(nums, 1);
        
        // Try to make all elements equal to -1
        int opsToMakeAll_1 = countOperations(nums, -1);
        
        // Return true if either transformation is possible within k operations
        return opsToMakeAll1 <= k || opsToMakeAll_1 <= k;
    }
    
    private int countOperations(int[] nums, int target) {
        int[] temp = nums.clone(); // Work on a copy
        int operations = 0;
        int n = temp.length;
        
        // Greedy approach: scan from left to right
        for (int i = 0; i < n - 1; i++) {
            if (temp[i] != target) {
                // Flip both temp[i] and temp[i+1]
                temp[i] *= -1;
                temp[i + 1] *= -1;
                operations++;
            }
        }
        
        // Check if the last element matches the target
        if (temp[n - 1] != target) {
            return Integer.MAX_VALUE; // Impossible
        }
        
        return operations;
    }
}

// Alternative cleaner approach
class SolutionAlternative {
    public boolean canMakeEqual(int[] nums, int k) {
        int n = nums.length;
        
        // Count segments of consecutive elements that need to be flipped
        int segments1 = countSegmentsToTarget(nums, 1);
        int segments_1 = countSegmentsToTarget(nums, -1);
        
        // We need at least 'segments' operations to make all equal to target
        return segments1 <= k || segments_1 <= k;
    }
    
    private int countSegmentsToTarget(int[] nums, int target) {
        int n = nums.length;
        int segments = 0;
        boolean inWrongSegment = false;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != target) {
                if (!inWrongSegment) {
                    segments++;
                    inWrongSegment = true;
                }
            } else {
                inWrongSegment = false;
            }
        }
        
        return segments;
    }
}