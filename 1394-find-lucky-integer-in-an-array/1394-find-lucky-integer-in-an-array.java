class Solution {
    public int findLucky(int[] arr) {
        // map stores the integer and frequency of the integer
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // first the lucky integer = -1
        int luckyInteger = -1;
        for(int x: map.keySet()){
            // if the frequency of integer is equal to its value and the value is greater than the current lucky integer then update the lucky integer to the current value 
            if(map.get(x) == x && luckyInteger < x){
                luckyInteger = x;
            }
        }

        // return the luckky integer
        return luckyInteger;
    }
}