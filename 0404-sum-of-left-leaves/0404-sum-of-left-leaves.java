/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // if tree is empty then return directly 0
        if(root == null) return 0;
        int sum = 0;
        // check the left node is not null and left node is a leaf node
        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val; // if left node is not null and is a leaf node then add the value of left node is added to sum
        }
        // recursively calculate the sum of left leaves in the left and right subtree
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
        
    }
    
}