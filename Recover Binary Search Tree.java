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
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        List<TreeNode> array = new ArrayList<TreeNode>();
        pre = null;
        
        helper(array, root);
        
        if(array.size() < 1) return;
        
        TreeNode n1 = array.get(0);
        TreeNode n2 = array.get(array.size() - 1);
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void helper(List<TreeNode> array, TreeNode node){
        if(node == null) return;
        helper(array, node.left);
        
        if(pre != null){
            if(pre.val > node.val){
                array.add(pre);
                array.add(node);
            }
        }
        pre = node;
        helper(array, node.right);
    }
}
