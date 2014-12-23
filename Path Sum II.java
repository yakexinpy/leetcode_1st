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
    List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public List<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return result;
        helper(root, sum, new ArrayList<Integer>());
        return result;
    }
    
    public void helper(TreeNode node, int sum, ArrayList<Integer> path){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            if(sum == node.val){
                ArrayList<Integer> npath = new ArrayList<Integer>(path);
                npath.add(node.val);
                result.add(npath);
            }
            return;
        }    
        path.add(node.val);
        helper(node.left, sum - node.val, path);
        helper(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
        return;
    }
}
