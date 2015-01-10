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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int curLev = 1;
        int nextLev = 0;
        boolean reverse = false;
        
        List<Integer> res = new ArrayList<Integer>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            curLev--;
            if(reverse) 
                res.add(0, node.val);
            else
                res.add(node.val);
            
            if(node.left != null){   
                q.add(node.left);
                nextLev++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLev++;
            }
            
            if(curLev == 0){
                curLev = nextLev;
                nextLev = 0;
                reverse = reverse ? false : true;
                ret.add(new ArrayList<Integer>(res));
                res.clear();
            }
        }
        return ret;
    }
}
