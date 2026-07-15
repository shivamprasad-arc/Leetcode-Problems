class Solution {
    // time complexity: O(2*N) = O(N)
    // space complexity: O(1)
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        // find the oddSum and evenSum
        for(int i = 1; i <= 2*n; i++){
            if(i % 2 == 0){
                sumEven += i;
            }else{
                sumOdd += i;
            }
        }
        // return the greatest common divisor(HCF)
        return GCD(sumOdd, sumEven);
    }
    // function to find the gcd of two numbers using Euclidean algorithm
    private int GCD(int odd, int even){
        // repeat until the even number becomes 0
        while(even != 0){
            int temp = even;  // temp store the curr value of even
            even = odd % even;  // replace even with the remainder of odd / even
            odd = temp; // odd store the prevoius value of even
        }
        // when even becomes zero then odd store the GCD of two number
        return odd;
    }
    
}