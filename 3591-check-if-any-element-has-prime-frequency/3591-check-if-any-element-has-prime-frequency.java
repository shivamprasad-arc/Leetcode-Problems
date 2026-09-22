class Solution {
    // Time complexity: O(N)
    // Space complexity: O(N)
    public boolean checkPrimeFrequency(int[] nums) {
        // map stores the number and thier frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // traverse the map and check if the value of any key is prime then return true
        for(int X: map.keySet()){
            int freq = map.get(X);
            if(isPrime(freq)){
                return true;
            }
        }
        return false;
    }

    // This function checks the number is prime or not
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(int i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}