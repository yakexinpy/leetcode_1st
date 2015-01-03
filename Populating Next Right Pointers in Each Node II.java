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
            TreeLinkNode node = q.poll();
            curLev--;
            
            if(node.left != null){
                q.add(node.left);
                nextLev++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLev++;
            }
            
            if(curLev == 0){
                node.next = null;
                curLev = nextLev;
                nextLev = 0;
            }else{
                node.next = q.peek();
            }
        }
    }
}
