import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        for(int right=1; right<nums.length; right++){
            if(nums[right]==nums[left]){
                return nums[right];
                
            }
            left++;
        }
        return -1;
        
    }
}