class Solution {
    // Time complexity: O(N^2)
    // Space complexity: O(1)
    public int maximumWealth(int[][] accounts) {
        int richestCustomer = 0;
        // Traverse the arr and find the richest customer
        for(int i = 0; i < accounts.length; i++){
            int currCustomer = 0;
            // in each row find the current customer wealth
            for(int j = 0; j < accounts[i].length; j++){
                currCustomer += accounts[i][j];
            }
            // if current customer welath is greater than the richest customer then 
            // the value or current customer assigned to the richest customer
            if(richestCustomer < currCustomer){
                richestCustomer = currCustomer;
            }
        }

        // return the richest customer wealth
        return richestCustomer;
        
    }
}