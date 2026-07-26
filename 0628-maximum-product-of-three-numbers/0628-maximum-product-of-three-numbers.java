class Solution {
    // Time complexity = O(N logN)
    // Space complexity = O(1)
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        /* case 1: Product of first two most negative number and the largest number
         Example: -8,-6,-2,-1,3,4,8
         -8 * -6 * 8 => 408

         Two negative number becomes positive and give maximum product
         This case also works when all numbers are negative
         -8, -6, -4, -2, -1 ->  -8 * -6 * -1 => -48
        */
        // int StProd = nums[0] * nums[1] * nums[n - 1];
        
        /* Case 2: Product of three largest numbers
         Example: -8,-6,-2,-1,3,4,8
         3 * 4 * 8 => 96
         if there are no large negative number this will usully be maximum product
         */
        // int endProd = nums[n - 1] * nums[n - 2] * nums[n - 3];
        
        // Return the max of stProd and endProd
        // return Math.max(StProd, endProd);

        // or
        return Math.max((nums[0] * nums[1] * nums[n - 1]), (nums[n - 1] * nums[n - 2] * nums[n - 3]));
        
    }
}