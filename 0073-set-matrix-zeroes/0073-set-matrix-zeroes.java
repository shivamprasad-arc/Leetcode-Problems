class Solution {
    // Time complexity: O(n^2)
    // Space complexity: O(n)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // row[i] = true means the row i contains an zero
        boolean[] row = new boolean[m];
        // col[j] = true menas the col j contains an zero
        boolean[] col =  new boolean[n];

        // find the rows and column that contains zero ans mark that row and column as true
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        // Make the marked row completely zero
        for(int i = 0; i < m; i++){
            if(row[i]){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Make the marked column completely zero
        for(int j = 0; j < n; j++){
            if(col[j]){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}