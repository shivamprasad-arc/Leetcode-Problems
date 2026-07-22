class Solution {
    // Time complexity: O(N)
    // Space complexity: O(26) ~ O(1)
    public boolean checkIfPangram(String sentence) {
        // add the all unique characters of sentence to the set
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < sentence.length(); i++){
            set.add(sentence.charAt(i));

            // if the size of set is greater or equal to 26 then the sentence is panagram i.e., 
            // the sentence contains all letters of the english alphabets
            if(set.size() == 26){
                return true;
            }
        }
        // if the size of set is less than 26 then return false
        return false;
    }
}