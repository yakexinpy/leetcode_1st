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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null)
            return ret;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode last = null;
        TreeNode node = root;
        
        while(!stack.isEmpty()){
        	//TreeNode node = stack.peek();
            while(node != null && node.left != null){
                stack.push(node.left);
                node = node.left; 
            }
            
            node = stack.peek();
            if(node.right != null && node.right != last){
                stack.push(node.right);
                node = stack.peek();
            }else{
                last = stack.pop();
                ret.add(last.val);
                node = null;
            }
        }
        return ret;
    }
}
