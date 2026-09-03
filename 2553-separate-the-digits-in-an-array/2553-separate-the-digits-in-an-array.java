class Solution {
    public int[] separateDigits(int[] nums) {
        // arraylist stores the individual digits, we don't use directly array due to we don't know the size of new array after separation of digits
        ArrayList<Integer> list = new ArrayList<>();

        // traverse the nums array and store the individual digits
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            // we use temp list stores reversed digits of a number due to after extracting digits using % the digits comes in reversed order i.e, 123, --> 3, 2, 1 that is reversed 
            ArrayList<Integer> temp = new ArrayList<>();
            while(n != 0){
                temp.add(n % 10);
                n /= 10;
            }
            // then reverse the individuals digits of a current number i.e,
            // 3, 2, 1 -> 1, 2, 3
            Collections.reverse(temp);
            list.addAll(temp);  // then add all elements of temp list to the ans list
        }

        // then define the array of same size of list and add all elements to the array
        int ans[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}