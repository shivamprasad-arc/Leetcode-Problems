class Solution {
    // Optimized approach
    // Time complexity: O(N)
    // Space Complexity: O(1)
    public int lengthOfLastWord(String s) {
        int l = s.length() - 1;
        int count = 0;
        // Traverse the string from end and ignore the unnecessary space of the end of string
        while(l > 0 && s.charAt(l) == ' '){
            l--;
        }
        // Track the count of last word
        while(l >= 0 && s.charAt(l) != ' '){
            count++;
            l--;
        }
        return count;
    }
}