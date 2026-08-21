class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxRectangle = 0;
        int nsr[] =  new int[heights.length];
        int nsl[] = new int[heights.length];

        // find next smaller right index
        Stack<Integer> s = new Stack<>();
        for(int i = heights.length - 1; i >= 0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = heights.length;
            }else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        // find next smaller right index
        s = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        // calculate Largest Rectangle
        for(int i = 0; i < heights.length; i++){
            int ht = heights[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = ht * width;
            maxRectangle = Math.max(currArea, maxRectangle);
        }

        return maxRectangle;
    }
}