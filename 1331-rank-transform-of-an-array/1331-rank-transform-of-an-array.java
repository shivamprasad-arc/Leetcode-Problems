class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // create clone of array to sort the array due to initializing rank for min number (1)
        int[] sorted = arr.clone();
        Arrays.sort(sorted); 
        int rank = 1;
        // map stores the value and it's rank
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            // similar values share the same rank
            // different values have different rank
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], rank++);
            }
        }
        // ans stores the rank of each element
        sorted = new int[arr.length];

        for(int i = 0; i < sorted.length; i++){
            sorted[i] = map.get(arr[i]);  // give the rank on the basis of element
        }
        // return rank transformed array
        return sorted;
    }
}