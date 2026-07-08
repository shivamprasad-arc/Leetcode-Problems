class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0; // if array is empty then return 0;
        // due to sorted array the first unique element is at first index so store the first element as unique.
        int unique = nums[0];
        // x counts unique elements, Initially first index is always unique 
        int x = 1;
        // j is the index of unique elements where unique elements should be placed
        // j is starts with 1 because the first unique elements is placed at the right position
        int j = 1;

        // Traverse the elements from second index
        for(int i = 1; i < nums.length; i++){
             // if the current element is different from last unique element 
            if(unique != nums[i]){
                x++; // update the counts of unique elements
                unique = nums[i]; // update the current unique elemnts
                nums[j++] = nums[i]; // place the new unique element at index j
            }
        }
        return x;
    }
}