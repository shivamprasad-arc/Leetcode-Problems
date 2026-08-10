class Solution {
    // time complexity: O(N)
    // Space commplexity: O(1)
    public boolean isBalanced(String num) {
        int evenSum = 0;  // stores the sum of even index digits sum
        int oddSum = 0;    // stores the sum of odd index digits sum
        for(int i = 0; i < num.length(); i++){
            // find the current digit
            int x = num.charAt(i) - '0';
            // stores the sum of  even and odd index digits in evenSum and oddSum simultaneously
            if(i % 2 == 0){
                evenSum += x;
            }else{
                oddSum += x;
            }
        }
        // if both sum are equal then return true else false
        return evenSum == oddSum;
    }
}