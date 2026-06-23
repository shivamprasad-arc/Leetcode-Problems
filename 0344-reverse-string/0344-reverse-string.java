class Solution {
    //Time complexity: O(N)
    // Space complexity: O(1)
    // Optimized approach : two pointer approach
    public void reverseString(char[] s) {
        int st = 0;   // store the index of first character
        int end = s.length - 1;  // store the index of last character
        // Change the character fisrt to last and last to first while st is less than end
        while(st < end){ 
            char first = s[st];
            char last = s[end];
            // change character and update the st by +1 and end by -1
            s[st++] = last;
            s[end--] = first;
        }
    }
}