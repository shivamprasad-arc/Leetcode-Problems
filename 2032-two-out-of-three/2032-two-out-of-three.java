class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>();  // list store the answer
        HashSet<Integer> s1 = new HashSet<>();  // set 1 store the all unique elements of nums1
        HashSet<Integer> s2 = new HashSet<>();  // set 2 store the all unique elements of nums2
        HashSet<Integer> s3 = new HashSet<>();  // set3 store the all unique elements of nums3

        // traverse the array nums1 and store all the unique elements to set1
        for(int i: nums1){
            s1.add(i);
        }

         // traverse the array nums2 and store all the unique elements to set2
        for(int i: nums2){
            s2.add(i);
        }

         // traverse the array nums3 and store all the unique elements to set3
        for(int i: nums3){
            s3.add(i);
        }

        // Traverse the set 1 and check if the current element is present in the set2 or set3 then add to the list
        for(int x: s1){
            if(s2.contains(x) || s3.contains(x)){
                list.add(x);
            }
        }

        // Traverse the set2 and check if the current element is present in the set3 and not present in th answer list then add the current element to the answer list
        for(int x: s2){
            if(s3.contains(x) && !list.contains(x)){
                list.add(x);
            }
        }

        // return the answe list
        return list;
    }
}