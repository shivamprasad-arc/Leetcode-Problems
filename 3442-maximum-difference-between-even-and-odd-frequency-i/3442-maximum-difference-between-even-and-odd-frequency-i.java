class Solution {
    public int maxDifference(String s) {
        // Map stores the character and their frequency of the string
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // find minEven freq and maxOdd freq
        int minEven = Integer.MAX_VALUE;
        int maxOdd = Integer.MIN_VALUE;
        for(char x: map.keySet()){
            // if the current freq is even and greater then the maxEven then update the value fo maxEven
            if(map.get(x) % 2 == 0 && map.get(x) < minEven){
                minEven = map.get(x);
            }
            // if the current freq is odd and greater then hte maxOdd then update the value of maxOdd
            else if(map.get(x) % 2 == 1 && map.get(x) > maxOdd){
                maxOdd = map.get(x);
            }
        }
        // return the maximum difference of even and odd frequency
        return maxOdd - minEven;
    }
}