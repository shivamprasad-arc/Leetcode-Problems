class Solution {
    public boolean isPowerOfTwo(int n) {
        // Base case: If n == 1 i.e., 2^0 =1 then return true
        if(n == 1) return true;

        //Base case: if n is negative then directly return false
        if(n <= 0) return false;

        // then recursively call for half of n i.e., it is divisible by 2
        if(n % 2 == 0){
            return isPowerOfTwo(n / 2);
        }

        // if it is not divisible  by 2 then return false;
        return false;
    }
}