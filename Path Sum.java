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
    class Result{
        boolean result;
        int sum;
        
        public Result(boolean b, int s){
            result = b;
            sum = s;
        }
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        Result res = helper(root, sum);
        return res.result;
    }
    
    private Result helper(TreeNode n, int rest){
        if(n.val == rest && n.left == null && n.right == null)
            return new Result(true, rest);
        
        if(n.left != null){
        Result l = helper(n.left, rest - n.val);
        if(l.result)
            return l;
        }
        if(n.right != null){
        Result r = helper(n.right, rest - n.val);
        if(r.result)
            return r;
        }
        return new Result(false, rest);
    }
}
