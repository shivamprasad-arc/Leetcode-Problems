class Solution {
    // Brute Force Approach
    // Time complexity: O(N)
    // Space complexity: O(1)
    public int[] sortedSquares(int[] nums) {
        // square the all elements of array and initialize with root value
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums); // sort the square array 
        return nums;
    }
}