class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        // traverse the patterns array and find if the word contains the current string then update the value of count by 1
        for(int i = 0; i < patterns.length; i++){
            if(word.contains(patterns[i])){
                cnt++;
            }
        }
        return cnt;
    }

}