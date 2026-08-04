class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // list to store all missing numbers
        List<Integer> list = new ArrayList<>();

        // priority queue for arrange the elements of nums array in ascending order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }

        // remove and store the smallest element this is first smallest element 
        int current = pq.remove(); // first element

        // continue until all elements of min heap is processed
        while(!pq.isEmpty()){

            // if next element in the heap is not consecutive then one or more than one elements are missing
            // example current = 2 and pq.peek() = 7
            // then the missing elements are [3,4,5,6]
            while(current + 1 < pq.peek()){
                // move to next expected number and store to the list 
                list.add(++current);
            }
            
            // if the sequence is consecutive then remove the next peek element of the queue and update the value of current
            current = pq.remove();
        } 

        // return the list
        return list;
    }
}