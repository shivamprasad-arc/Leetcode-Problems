class Solution {
    // Time complexity: O(1)
    // Space complexity: O(1)
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // Find the common width:
        // The right boundary of the overlap is the smaller of the two right boundaries.
        // The left boundary of the overlap is the larger of  the two left boundaries.
        int commonWidth = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);

        // Find the common height:
        // The top boundary of the overlap is the smaller of the two top boundaries.
        // The bottom boundary of the overlap is the larger of the two bottom boundaries.
        int commonHeight = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        
        // For a proper overlap:
        // commonWidth must be > 0
        // AND
        // commonHeight must be > 0
        //
        // If either is 0 or negative, rectangles only touch or don't overlap.
        return commonWidth > 0 && commonHeight > 0;
    }
}