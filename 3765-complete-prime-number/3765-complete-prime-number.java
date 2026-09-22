class Solution {
    // Time complexity: O(N)
    // Space complexity: O(N)
    public boolean completePrime(int num) {
        // convert number into string
        String s = Integer.toString(num);
        int n = s.length();
        long prefix = 0;
        // check for all prefix that it is prime or not 
        for(int i = 0; i < n; i++){
            prefix = prefix * 10 + (s.charAt(i) - '0');
            if(!isPrime(prefix)) return false;
        }

        long suffix = 0;
        long place = 1;
        // check for all suffix that it is prime or not 
        for(int i = n - 1; i >= 0; i--){
            suffix += (s.charAt(i) - '0') * place;
            place *= 10;
            if(!isPrime(suffix)) return false;
        }

        return true;
    }

    // This function checks if a number is prime or not 
    public static boolean isPrime(long num){
        if(num < 2) return false;
        if(num < 4) return true;
        if(num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i += 6){
            if(num % i == 0 || num % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}