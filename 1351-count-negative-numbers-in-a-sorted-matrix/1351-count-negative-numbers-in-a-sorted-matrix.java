class Solution {
    // Brute force approach
    // time complexity: O(N^2)
    // space complexity: O(1)
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] < 0) cnt++;
            }
        }
        return cnt;
    }
}