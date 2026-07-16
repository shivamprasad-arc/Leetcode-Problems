class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        int sum = 0;
        // while num has only 1 digits left
        while(num > 9){
            sum = 0;  // reset sum for next iteration
            // find the sum of all digits of current number
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;  // update the new value of num as sum -> 38 -> 3 + 1 = 11(sum) it is the next num
        }
        return sum;  // return when num has only single digit left
    }
}