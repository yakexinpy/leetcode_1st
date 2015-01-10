/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        q.add(node);
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, newNode);
        
        while(!q.isEmpty()){
            UndirectedGraphNode t = q.poll();
            UndirectedGraphNode newt = map.get(t);
            for(UndirectedGraphNode n : t.neighbors){
                if(!map.containsKey(n)){
                    UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
                    q.add(n);
                    map.put(n, newN);
                    newt.neighbors.add(newN);
                }
                else{
                    newt.neighbors.add(map.get(n));
                }
            }
            
        }
        
        return newNode;    
    }
}
