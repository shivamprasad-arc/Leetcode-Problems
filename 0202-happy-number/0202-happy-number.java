class Solution {
    public boolean isHappy(int n) {
        // set is used for store the number that we have already seen
        // it helps to detect cycle, so it protects to infinte loop
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            // if the current number is already exists in the set so the cycle exists so return false
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = Square(n);
        }
        return true;
    }
    public static int Square(int n){
        int sq = 0;
        while(n != 0){
            int num = n % 10;
            n /= 10;
            sq += (num * num);
        }
        return sq;
    }
}