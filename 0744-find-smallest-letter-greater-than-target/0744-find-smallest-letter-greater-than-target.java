class Solution {
    // Time complexity: O(N)
    // Space complexity: O(1)
    // find smallest letter greater then target because the array of character is sorted in non-decreasing order so apply for loop and the first greater letter then target in the array is the answer character
    public char nextGreatestLetter(char[] letters, char target) {
        for(int i = 0; i < letters.length; i++){
            if(target < letters[i]){
                return letters[i];
            }
        }
        // if there is no characters in letters array so we return letter[0]
        return letters[0];
    }
}