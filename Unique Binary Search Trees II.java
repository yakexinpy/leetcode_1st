/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1) {
            List<TreeNode> ret = new ArrayList<TreeNode>();
            ret.add(null);
            return ret;
        };
        return helper(1, n);
    }
    
    public ArrayList<TreeNode> helper(int left, int right){
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(left > right){
            ret.add(null);
            return ret;
        }
        
        for(int i = left; i < right + 1; i++){
            ArrayList<TreeNode> leftTrees = helper(left, i - 1);
            ArrayList<TreeNode> rightTrees = helper(i + 1, right);
            for(int j = 0; j < leftTrees.size(); j++){
                for(int k = 0; k < rightTrees.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTrees.get(j);
                    root.right = rightTrees.get(k);
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
