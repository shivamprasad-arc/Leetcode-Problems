class Solution {
    // Time complexity: O(N logN)
    // Space complexity: O(N)
    public int lastStoneWeight(int[] stones) {
        // max heap stores the values in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // traverse the stone array and store in max heap
        for(int i = 0; i < stones.length; i++){
            pq.add(stones[i]);
        }
        // combine the heaviest two stones and the difference of two heaviest stone stored to the max heap
        // continue until only one stones are left
        while(pq.size() > 1){
            pq.add(pq.remove() - pq.remove());
        }
        // return the last remaining stone left
        return pq.remove();
    }
}