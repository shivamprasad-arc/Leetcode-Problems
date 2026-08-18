class Solution {
    //Time complexity: O(N)
    // Space Complexity: O(1)
    public int[] plusOne(int[] digits) {
         // Start from the last digit because we need to add 1from the right side.
        // Example:
        // [1, 2, 9]
        //        ↑
        //       start here
        for(int i = digits.length - 1; i >= 0; i--){
            // If the current digit is less than 9,we can simply add 1 to it.
            // Example: [1, 2, 3]
            //        3 < 9 -->  3 + 1 = 4
            //        Result = [1, 2, 4]
            if(digits[i] < 9){
                digits[i]++; // add one to current digit
                return digits; // return the digits array
            }

            // If the current digit is 9,adding 1 makes it 10.
            // We cannot store 10 in one array position, so we make the current digit 0.
            
            // The remaining +1 becomes a carry to the digit on the left.
        
            // Example: [1, 2, 9]
            // 9 -> 0  Result temporarily = [1, 2, 0]
            digits[i] = 0;
        }

        // If the loop finishes without returning, it means every digit was 9.
        // Example: [9, 9, 9]
        // After the loop: [0, 0, 0]
        // We need one extra position for the leading 1.
        int result[] = new int[digits.length + 1];
         // Put 1 at the first position.
        // [0, 0, 0, 0]
        //  ↑
        //  1
        // Result = [1, 0, 0, 0]
        result[0] = 1;
        return result;
    }
}