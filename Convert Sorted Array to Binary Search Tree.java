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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length < 1)
            return null;
        int mid = (num.length - 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(0, mid - 1, num);
        root.right = helper(mid + 1, num.length - 1, num);
        return root;
    }
    
    private TreeNode helper(int start, int end, int[] num){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(start, mid - 1, num);
        root.right = helper(mid + 1, end, num);
        return root;
    }
}
