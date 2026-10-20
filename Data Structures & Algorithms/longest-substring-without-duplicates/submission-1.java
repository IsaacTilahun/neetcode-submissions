class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /**
        im starting to get lazy to explain these solutions

        time complexity: O(n^2) because it can become summation(n, n-1, n-2, ... 1)
        space complexity: O(n) we holding the set and the list
        
        */


        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            HashSet<Character> set = new HashSet<>();
            int count = 0;
            int oldI = i;

            while (i < s.length() && !set.contains(s.charAt(i))) {

                set.add(s.charAt(i));
                count++;
                i++;
                
            }

            i = oldI; // Dont do oldI + 1, because the i++ in the for loop statement automatically adds that one after
            if (count > max) {
                max = count;
            }


        }

        return max;

    }
}
