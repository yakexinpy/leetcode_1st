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
    int max; 
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        max = Integer.MIN_VALUE;
        int res =  helper(root);
        return Math.max(res, max);
    }
    
    private int helper(TreeNode node){
        if(node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        
        int self = node.val;
        int total = self + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        left += self;
        right += self;
        
        //a complete path
        max = Math.max(max, total);
        
        return Math.max(Math.max(left, right), self);
    }
}
