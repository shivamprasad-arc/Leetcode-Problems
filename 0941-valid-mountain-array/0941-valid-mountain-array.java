class Solution {
    public boolean validMountainArray(int[] arr) {
        // check if a mountain array contain elements less then 3 then return false
        if(arr.length < 3) return false;
        int i = 0;
        // move forward while the array is strictly increasing
        while(i < arr.length - 1 && arr[i] < arr[i+1]){
            i++;
        } 
        // if the pointer is at first position i.e., no strictly increasing elements is present
        // or if the pointer is at last index i.e., no strictly decreasing elements is present
        if(i == arr.length - 1 || i == 0) return false;

        // move forward while the array is strictly decreasing
        while(i < arr.length - 1 && arr[i] > arr[i+1]){
            i++;
        }

        // return true if we success fully reach at the last index otherwise return false
        return i == arr.length - 1;
    }
}