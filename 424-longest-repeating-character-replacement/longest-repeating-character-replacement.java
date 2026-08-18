class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Highest frequency character in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // Number of replacements required
            int replacements = (right - left + 1) - maxFreq;

            // Window is invalid
            while (replacements > k) {

                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;

                left++;

                replacements = (right - left + 1) - maxFreq;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}