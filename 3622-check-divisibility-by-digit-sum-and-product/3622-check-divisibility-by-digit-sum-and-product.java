class Solution {
    // Time complexity: O(log n) 
    // Space complexity: O(1)
    public boolean checkDivisibility(int n) {
        int sum = 0;  // stores digit sum 
        int prod = 1; // stors digit product
        int copy = n;
        // repeat unitl n is greater then zero
        while(n > 0){ 
            // find a single digit as x 
            int x = n % 10;
            // then add to the sum and multiply to the product
            sum += x;  
            prod *= x;
            n /= 10;  // remove that digit i.e., update the value of n
        }

        //  Check whether original number is divisible by (sum of digits + product of digits) 
        return copy % (sum + prod) == 0 ? true : false;
    }
}