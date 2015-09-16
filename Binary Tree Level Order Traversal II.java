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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int curLev = 1;
        int nextLev = 0;
        
        List<Integer> list = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            curLev--;
            list.add(n.val);
            if(n.left != null){
                q.add(n.left);
                nextLev++;
            }
            if(n.right != null){
                q.add(n.right);
                nextLev++;
            }
            if(curLev == 0){
                curLev = nextLev;
                nextLev = 0;
                result.add(0,list);
                list = new ArrayList<Integer>();
            }
        }
        return result;   
    }
}
