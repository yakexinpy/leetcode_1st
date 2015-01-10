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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        int sum = 0;
        int cur = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        Stack<Integer> curSum = new Stack<Integer>();
        curSum.push(cur);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            cur = curSum.pop();
            cur = cur * 10 + node.val;
            
            if(node.left == null && node.right == null){
                sum += cur;
                //cur = cur / 10;
                continue;
            }
            if(node.right != null){
                stack.push(node.right);
                curSum.push(cur);
            }
            if(node.left != null){
                stack.push(node.left);
                curSum.push(cur);
            }
        }
        
        return sum;
    }
}
