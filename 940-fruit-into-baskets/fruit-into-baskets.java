
class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add current fruit
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // More than 2 fruit types
            while (map.size() > 2) {

                int leftFruit = fruits[left];

                map.put(leftFruit, map.get(leftFruit) - 1);

                // Remove fruit type completely
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }

                left++;
            }

            // Current valid window
            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}