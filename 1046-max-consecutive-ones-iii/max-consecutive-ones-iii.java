class Solution {
    public int longestOnes(int[] nums, int k) {

        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Add the new element
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Too many zeros, shrink window
            while (zeroCount > k) {

                if (nums[left] == 0) {
                    zeroCount--;
                }

                left++;
            }

            // Current window is valid
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}