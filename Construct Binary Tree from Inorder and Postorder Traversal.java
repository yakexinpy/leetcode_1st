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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length < 1) return null;
        if(postorder == null || postorder.length < 1) return null;
        if(inorder.length != postorder.length) return null;
        
        index = postorder.length - 1;
        return helper(0, inorder.length - 1, inorder, postorder);
    }
    
    private TreeNode helper(int start, int end, int[] inorder, int[] postorder){
        if(start > end || index < 0){
            index++;
            return null;
        }
        
        TreeNode node = new TreeNode(postorder[index]);
        int mid = 0;
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == postorder[index]){
                mid = i;
                break;
            }
        
        index--;
        node.right = helper(mid + 1, end, inorder, postorder);
        index--;
        node.left = helper(start, mid - 1, inorder, postorder);
        return node;
    }
}
