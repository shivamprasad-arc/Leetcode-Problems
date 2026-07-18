class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        // find the smallest and largest element of the array
        for(int i = 0; i < nums.length; i++){
            if(smallest >= nums[i]){
                smallest = nums[i];
            }
            if(largest <= nums[i]){
                largest = nums[i];
            }
        }

        // Find the GCD of smallest and largest element of the array
        while(smallest != 0){
            int temp = smallest;
            smallest = largest % smallest;
            largest = temp;
        }
        // return the largest element that is GCD of smallest and largest element
        return largest;
    }
}