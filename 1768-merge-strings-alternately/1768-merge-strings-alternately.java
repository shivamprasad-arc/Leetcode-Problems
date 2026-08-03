class Solution {
    // Time complexity: O(m + n)
    // Space complexity: O(m + n)
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder is used for answer because it is efficient for appending multiple characters
        StringBuilder ans = new StringBuilder();
        int i = 0;  // track the index of both strings

        // traverse and append the characters alternately the characters of both strings while on of them is not ends.
        while(i < word1.length() && i < word2.length()){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
            i++;
        }

        // if word1 is longer then append the remaining characters to the ans string
        while(i < word1.length()){
            ans.append(word1.charAt(i++));
        }

        // if word2 is longer then append the remainig characters to the ans string
        while(i < word2.length()){
            ans.append(word2.charAt(i++));
        }

        // return the ans -> convert it string builder to string
        return ans.toString();
    }
}