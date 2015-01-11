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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1 || preorder.length != inorder.length)  return null;
        index = 0;
        return helper(0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int start, int end, int[] preorder, int[] inorder){
        if(start > end || index > preorder.length - 1) {
            index--;
            return null;
        }
            
        TreeNode node = new TreeNode(preorder[index]);
        int mid = 0;
        
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == preorder[index]){
                mid = i;
                break;
            }
        index++;
        node.left = helper(start, mid - 1, preorder, inorder);  
        index++;
        node.right = helper(mid + 1, end, preorder, inorder);
        return node;
    }
}
