class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;// slow tracks the next non zero element index
        // fast pointer traverse the array from left to right
        for(int fast = 0; fast < nums.length; fast++){
            // if current element is zero the move to the next element 
            if(nums[fast] != 0){
                // if current element is not eqalt to zero then swap the slow index element and fast index element
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                // move slow to the next index
                slow++;
            }
        } 
    }
}