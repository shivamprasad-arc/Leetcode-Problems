class Solution {
    public int trap(int[] height) {
        int n = height.length;

        //leftMax stores the maximum height from o to i index
        int leftMax[] = new int[n];
        // for the first element the max height on it's left is the element itself
        leftMax[0] = height[0];

        // build the left max array
        for(int i = 1; i < n; i++){
            // leftMax is the maximum of previous max height and current height
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        // rightMax[i] stores the maximum height
        // from index i to the last index
        int rightMax[] = new int[n];

        // For the last element, the maximum height
        // on its right is the element itself
        rightMax[n-1] = height[n-1];

        // Build the rightMax array from right to left
        for(int i = (n-2); i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int trappedWater = 0;
        for(int i = 0; i < n; i++){
            // Maximum of next right maximum
            // and current height
            int waterLevel = Math.min(rightMax[i], leftMax[i]);

             // Water trapped at current index = water level - height of current bar
            trappedWater += (waterLevel - height[i]);
        }
        // Return total trapped water
        return trappedWater;
    }
}