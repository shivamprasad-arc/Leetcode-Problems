class Solution {
    public int findComplement(int num) {
        // first convert the decimal to binary 
        String bin = decToBin(num);
        int dec = 0;
        int power = 0;  // it tracks the power of 2

       // Traverse the binary string from RIGHT to LEFT.
        // We start from the last character because the rightmost
        // binary digit represents 2^0.
        for(int i = bin.length() - 1; i >= 0; i--){
            int curr = bin.charAt(i) - '0';
           // We need the complement of every binary bit: 0 -> 1 and 1 -> 0

            // Therefore, if the current bit is 0, its complement is 1.
          
            // We add 2^power because this complemented bit contributes to the decimal value.
            if(curr == 0){
                dec += (1 * Math.pow(2, power));
            }
            power++; // move for next binary position
        }
        return dec;  // return the number complement
    }

    //This function converts teh decimal number to binary number
    public static String decToBin(int num){
        StringBuilder bin = new StringBuilder();
        while(num != 0){
            int rem = num % 2;

            //Add the digit, it is generated from Right to Left
            // for example 10 -> 1010 (real)
            // but it generates -> 10 -> 0101
            bin.append(rem);
            num /= 2;
        }

        // first reverse the generated binary to correct the order and converted into SB ot string
        // 0101 -> 1010 (that is correct binrary of 10)
        return bin.reverse().toString();
    }

}