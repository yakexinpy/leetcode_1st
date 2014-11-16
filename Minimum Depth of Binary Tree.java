/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int min;
        if(root.left == null)
            min = minDepth(root.right);
        else if(root.right == null)
            min = minDepth(root.left);
        else
            min = Math.min(minDepth(root.left), minDepth(root.right));
        min += 1; 
        return min;
    }
}
