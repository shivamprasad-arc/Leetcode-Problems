class Solution {
    // Time complexity = O(N)
    // Space Complexity: O(N)
    public int maxProduct(int n) {
        // create a max heap and stores all single digit of the number n in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(n > 0){
            pq.add(n % 10);
            n /= 10;
        }
        // the product of first two digit of descending order max heap is the max product of tho digits
        return pq.remove() * pq.remove();
    }
}