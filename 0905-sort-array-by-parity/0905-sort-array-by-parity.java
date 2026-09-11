class Solution {
    // Time complexity: O(N)
    // space complexity: O(1)
    // two pointer approach 
    // all even integer move at beginning and odd elements move to last of the array
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            // If the element at the left pointer is ODD, it is in the wrong place.
            // It needs to be moved to the back of the array.
            if(nums[left] % 2 != 0){
                // so swap the number to the right pointer 
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;  // so at right/last position ODD number is placed by swaping so reduce the right index by one
            }else{
                left++;  // if left pointer number is EVEN then update the value of left by one
            }
        }
        return nums; // return nums array
    }

}