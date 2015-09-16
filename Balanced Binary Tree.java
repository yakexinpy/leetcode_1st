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
        boolean res;
        int depth;
        
        public Result(boolean b, int d){
            res = b;
            depth = d;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        Result res = isBalancedHelper(root);
        return res.res;
    }
    
    private Result isBalancedHelper(TreeNode root){
        if(root == null)
            return new Result(true, 0);
        Result l = isBalancedHelper(root.left);
        if(!l.res){
                return new Result(false,0);
        }
        Result r = isBalancedHelper(root.right);
        if(!r.res){
                return new Result(false,0);
        }
        int dep = Math.abs(l.depth - r.depth);
        boolean b = (dep <= 1);
        return new Result(b, Math.max(l.depth, r.depth) + 1);
    }
    
}
