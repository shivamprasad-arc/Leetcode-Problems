class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        // traverse from the range left to right if the current number is self dividing number then add the list
        for(int i = left; i <= right; i++){
            if(isSelfDivided(i)){
                list.add(i);  // store all self divided number in the range of left and right
            }
        }
        // return ans
        return list;
    }

    // isSelfDivided function check a number is self divided or not
    public static boolean isSelfDivided(int n){
        // store the original number in temp 
        int temp = n; 
        // traverse until temp is not equal to zero
        while(temp != 0){
            int lst_Dgt = temp % 10;  // find the last digit
            // if last digit is zero and the original number is not completely divided by last digit then return false i.e., the number is not self dividing number
            if(lst_Dgt == 0 || n % lst_Dgt != 0){
                return false;
            }
            // update the temp 
            temp /= 10;
        }
        // if the number is divided by each numbers then return true i.e., it is self divided number
        return true;
    }
}