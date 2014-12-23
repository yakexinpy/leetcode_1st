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
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return helper(root);
    }
    
    TreeNode last = null;
    
    public boolean helper(TreeNode node){
        if(node == null)    
            return true;
        boolean l = helper(node.left);
        if(!l) return false;
        if(last != null && node.val <= last.val)
            return false;
        last = node;
        boolean r = helper(node.right);
        return r;
    }
}
