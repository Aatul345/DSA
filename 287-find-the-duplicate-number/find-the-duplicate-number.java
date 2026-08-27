class Solution {
    public int findDuplicate(int[] nums) {
        
        // Phase 1: Find intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance of the cycle
        int start = nums[0];

        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }

        return start;
    }
}