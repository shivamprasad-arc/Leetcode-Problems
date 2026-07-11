class Solution {
    // Brute Force approach
    // Time complexity: O(N)
    // Space Complexity: O(N)
    public int lengthOfLastWord(String s) {
        // all words are putted to the string array on the basis of space between the words
        String[] str = s.split(" ");
        // return the length of last word
        return str[str.length - 1].length();
    }
}