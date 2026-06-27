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
    // Optimized solution
    // TC = O(N)
    // SC = O(N)
    //Using the approach of left side view of Binary Tree 
    // I traverse the tree in Level order 
    // and add the first node of each level in the ans node 
    // the the last updated ans node is the Bottom left value
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        // prev tracks it the prev node is null the next node is the ans
        TreeNode prev = root;
        TreeNode ans = root;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(prev == null){
                ans = curr;
            }
            prev = curr;
        }
        return ans.val;
    }
}