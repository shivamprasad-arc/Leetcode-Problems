class Solution {
    // Time complexity: O(N)
    // Space Complexity: O(1)
    public int maxProduct(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        // traverse the array and find the the first and second largest
        for(int i = 0; i < nums.length; i++){
            // if first is less than the current number then second updated to first and 
            // first updated to current number
            if(nums[i] > first){
                second = first;
                first = nums[i];
            }else if(nums[i] > second){
                // if current number is greater than the second number then second number is current number
                second = nums[i];
            }
        }
        // return the maximum value of (nums[i]-1)*(nums[j]-1)
        return (first - 1) * (second - 1);
    }
}