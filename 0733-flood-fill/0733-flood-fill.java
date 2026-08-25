// Approach: DFS + recursion
// Time complexity: O(n X m)
// Space complexity: O(n X m)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // store the original color of starting cell
        int initialCol = image[sr][sc];

        // create a copy of image array
        int[][] copy = new int[image.length][];
        for(int i = 0; i < image.length; i++){
            copy[i] = image[i].clone();
        }

        //  We can move in 4 directions:                               
//                                           
//                     UP (-1,0)                   
//                         ↑                       
//                         |                       
//      (0, -1) LEFT ←  (row,col)  → RIGHT (0, +1)         
//                         |                       
//                         ↓                       
//                    DOWN (+1,0) 
        // These arrays represent the 4 possible directions.
        //       delRow    delCol
        // UP       -1        0
        // RIGHT     0       +1
        // DOWN     +1        0
        // LEFT      0       -1
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        // start dfs from sr and sc
        dfs(image, copy, sr, sc, color, initialCol, delRow, delCol);
        return copy;  // return colored image
    }

    // flood fill dfs
    public static void dfs(int[][] img, int[][] copy, int row, int col, int newColor, int initialColor, int[] delRow, int[] delCol){
        // Step 1: Assign the new color in current cell 
        copy[row][col] = newColor;
        int n = img.length;
        int m = img[0].length;

        // step2: check in all four direction
        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];  // calculate newRow
            int nCol = col + delCol[i];  // calculate newCol
            
            //  must check that nRow and nCol inside the boundary
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                // Step 4: Check whether neighbour can be filled
                // The neighbour should satisfy TWO conditions:
                // 1. Its original color must be initialCol.
                // 2. It should not already be changed to newColor.
                //
                // This prevents repeated recursive calls.
                if(img[nRow][nCol] == initialColor && copy[nRow][nCol] != newColor){
                    // neighbour is  valid so recursively perform floodfill for next neighbour
                    dfs(img, copy, nRow, nCol, newColor, initialColor, delRow, delCol);
                }
            }
        }
    }
}