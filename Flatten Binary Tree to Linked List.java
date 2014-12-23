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
    public void flatten(TreeNode root) {
        if(root == null) return ;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            if(node.right != null)
                stack.add(node.right);
            if(node.left != null){
                node.right = node.left;
                node.left = null;
            }
            else if(!stack.isEmpty()){
                node.right= stack.pop();
            }
            node = node.right;
        }
    }
}
