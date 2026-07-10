class Solution {
    //Time complexity = O(N)
    // SC: O(1)
    public int removeElement(int[] nums, int val) {
        // idx tracks the index of changed array and it also tracks the number of valid elements
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            // if current element is not equal to val than keep this element in array
            if(nums[i] != val){
                nums[idx++] = nums[i];
            }
        }
        // index is equal to the number of elements remaining after removal 'val'
        return idx;
    }
}