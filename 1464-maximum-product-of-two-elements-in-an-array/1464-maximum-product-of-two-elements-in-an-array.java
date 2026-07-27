class Solution {
    // Time complexity: O(N log N)
    // Space Complexity: O(1)
    public int maxProduct(int[] nums) {
        // sort the array in ascending order
        Arrays.sort(nums);
        int n = nums.length;
        // return the maximum value of (nums[i] - 1) * (nums[i] - 1)
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}