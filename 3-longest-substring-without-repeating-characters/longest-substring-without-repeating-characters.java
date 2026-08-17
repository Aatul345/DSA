
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If character already exists, move left
            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            // Store latest index of character
            map.put(ch, right);

            // Calculate current window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}