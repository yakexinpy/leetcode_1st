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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return  result;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curLev = 1;
        int nextLev = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            curLev--;
            list.add(node.val);
            if(node.left != null){
                q.add(node.left);
                nextLev++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLev++;
            }
            if(curLev == 0){
                result.add(list);
                curLev = nextLev;
                nextLev = 0;
                list = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
