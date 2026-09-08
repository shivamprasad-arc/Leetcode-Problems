// Time Complexity: O(N log N)
// Space Complexity: O(1)
class Solution {
    // calculates total commas for all numbers from 1 to n
    public int countCommas(int n) {
        // if the number is less than 1000 have no commas 
        if(n < 1000) return 0;
        int commas = 0;

        // find numbers of commas starting from 1000 because less than 1000  have no commas
        for(int i = 1000; i <= n; i++){
            commas += countCommasIndividually(i);  // this function calcualtes comma of current number  
        }
        return commas;
    }

    // this function calcualte number of commas in a individual number 
    public static int countCommasIndividually(int n){
        int count = 0;
        while(n != 0){
            count++;
            n /= 10;
        }

        // Fix for boundary lengths (e.g., 6 digits like 100,000 need 1 comma, not 2)
        if(count % 3 == 0) return count / 3 - 1;
        // Base case formula for other digit lengths
        return count / 3;
    }
}