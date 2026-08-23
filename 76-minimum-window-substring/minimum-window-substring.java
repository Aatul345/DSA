import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        // Store frequency of characters required from t
        Map<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        // Number of unique characters that must have correct frequency
        int required = need.size();
        int formed = 0;

        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        // Expand the window
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Add current character to window
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Check if this character's required frequency is satisfied
            if (need.containsKey(ch) &&
                window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            // Window is valid, try to minimize it
            while (formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Remove left character and shrink window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // Window is no longer valid
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minStart, minStart + minLength);
    }
}