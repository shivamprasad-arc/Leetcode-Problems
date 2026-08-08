class Solution {
    public int digitFrequencyScore(int n) {
        // HashMap stores the digits and their frequencies
        HashMap<Integer, Integer> map = new HashMap<>();

        while(n > 0){
            // stores all digits and their frequencies
            map.put(n % 10, map.getOrDefault(n % 10, 0) + 1);
            n /= 10;  // update the value of n
        }
        int ans = 0;  // initially n = 0;
        // traverse the map and find digit frequency score
        for(int x: map.keySet()){
            // add to the answer  the product of digits and their frequencies
            ans += (x * map.get(x));
        }
        // return the answer
        return ans;
    }
}