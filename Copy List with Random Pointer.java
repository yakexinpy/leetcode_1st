/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        RandomListNode node = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        while(node != null){
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        while(node != null){
            RandomListNode cur = map.get(node);
            if(node.next != null)
                cur.next = map.get(node.next);
            if(node.random != null)
                cur.random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
