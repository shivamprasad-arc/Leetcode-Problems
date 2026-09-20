class Solution {
    // Time complexity: O(N)
    // Space complexity: O(1)
    public int reverseDegree(String s) {
        int revDeg = 0; // stores the total reverse degree
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            // Reverse alphabet value: 'z' - 'z' = 0, 'z' - 'y' = 1 
            // z = 1, y = 2, x = 3, ..., a = 26
            // Multiply it by the 1-based position (i + 1)
            int currDeg = ('z' - ch + 1) * (i + 1);
            revDeg += currDeg;
        }
        return revDeg;
    }
}