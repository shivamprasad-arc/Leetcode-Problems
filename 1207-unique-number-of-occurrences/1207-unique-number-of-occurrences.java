class Solution {
    // Time complexity: O(N)
    // Space Complexity: O(N+N) = O(N)
    public boolean uniqueOccurrences(int[] arr) {
        // map is used to store the number and their occurences
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        // set stores the unique occurences of the map 
        // if the occurences is same then ignore it
        HashSet<Integer> set = new HashSet<>();
        for(Integer val: map.keySet())
        {
            set.add(map.get(val));
        }
        // if the size of both map and set is equal then each element of array has unique occurences
        // else if the size of both map and set is different then the each element of array hasn't unique occurence
        return map.size() == set.size() ? true : false;
    }
}