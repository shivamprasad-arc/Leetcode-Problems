class Solution {
    // Time complexity = O(N logN)
    // Space Complexity = O(N)
    public int findGCD(int[] nums) {
        // sort the array to find the smallest and largest number
        Arrays.sort(nums);
        int smallest = nums[0];
        int largest = nums[nums.length - 1];
        // find the GCD of smallest and largest number of the array
        while(smallest != 0){
            int temp = smallest;
            smallest = largest % smallest;
            largest = temp;
        }
        return largest;
    }
}