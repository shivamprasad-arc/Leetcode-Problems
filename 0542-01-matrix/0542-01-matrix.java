class Solution {
    // Time Complexity  : O(n × m)
    // Space Complexity : O(n × m)
    static class cell{
        int row;
        int col;
        int dist;
        public cell(int row, int col, int dist){
            this.row = row;  // row idx
            this.col = col; // col idx
            this.dist = dist;  // distance from nearest 0
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // queue is used for BFS it stores (row, idx, distance)
        Queue<cell> q = new LinkedList<>();

        // create a copy array of mat
        int[][] copy = new int[n][];
        // find the first 0 element of the matrix array
        for(int i = 0; i < mat.length; i++){
            copy[i] = mat[i].clone();
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    q.add(new cell(i, j, 0));
                }
            }
        }

        // For possible direction : up left, down right
        // direction   delRow    delCol
        //   up           -1      0
        //   right         0      1
        //  down           1      0
        // left            0      -1
        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        // Perform BFS
        while(!q.isEmpty()){
            cell curr = q.remove();  // remove current cell from the queue
            // check all four direction
            for(int i = 0; i < 4; i++){
                int nRow = curr.row + delRow[i];  // calculate new row
                int nCol = curr.col + delCol[i];  // calculate new column

                // Check whether the neighboring cell is inside the matrix
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    // If neighboring cell contains 1, it has not been visited yet
                    if(mat[nRow][nCol] == 1){
                        mat[nRow][nCol] = 0;  // Mark this cell as visited, so that we don't visit it again
                        // Distance of neighboring cell = current cell distance + 1
                        copy[nRow][nCol] = curr.dist + 1;
                        q.add(new cell(nRow, nCol, curr.dist + 1));  // add new cell to the queue with new row, col and updated distance
                    }
                }
            }
        }
        return copy;  // return copy matrix
    }
    
}