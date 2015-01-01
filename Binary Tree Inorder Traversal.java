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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null)
            return ret;
            
        helper(root, ret);
        return ret;
    }
    
    private void helper(TreeNode root, List<Integer>ret){
        if(root == null) return;
        helper(root.left, ret);
        ret.add(root.val);
        helper(root.right, ret);
    }
}
