/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        int curLev = 1;
        int nextLev = 0;
        while(!q.isEmpty()){
            TreeLinkNode cur = q.poll();
            curLev--;
            if(cur.left != null){
                q.add(cur.left);
                nextLev++;
            }
            if(cur.right != null){
                q.add(cur.right);
                nextLev++;
            }
            
            if(curLev == 0){
                cur.next = null;
                curLev = nextLev;
                nextLev = 0;
            }
            else{
                cur.next = q.peek();
            }
        }
    }
}
