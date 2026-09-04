class Solution {
    // time complextiy: O(log n)
    // space complexity: O(1)
    public int findMin(int[] nums) {
        // find the minimum in rotated sorted array or the rotation point of the sorted rotated array
        int st = 0; 
        int end = nums.length - 1;
        // while more than one element is present in the search range, the binary search performs
        while(st < end){
            // calculate mid index
            int mid = st + (end - st) / 2;
            // Agar nums[mid] > nums[end] hai,
            // iska matlab minimum element RIGHT side mein hai.
            // Example:
            // [4, 5, 6, 7, 0, 1, 2]
            //          ↑        ↑
            //         mid      end
            //
            // 7 > 2 hai, toh minimum 7 ke right mein hoga.
            if(nums[mid] > nums[end]){
                // igonre mid and left (st) element due the minimum element is definitely lies in the right side
                st = mid + 1;
            }else{
                // Agar nums[mid] <= nums[end] hai,
                // toh minimum mid ya mid ke LEFT side ho sakta hai.
                // Isliye mid ko eliminate nahi karenge.
                end = mid;
            }
        }
        // when st == end, only one element is present in the serch range that is that element is the minimum elements
        return nums[st];
    }
}