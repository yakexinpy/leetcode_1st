public class LRUCache {
    class DoubleLinkedNode{
        int key;
        int val;
        DoubleLinkedNode pre;
        DoubleLinkedNode next;
        public DoubleLinkedNode(int k,int v){
            key = k;
            val = v;
        }
    }
    
    Map<Integer, DoubleLinkedNode> map;
    DoubleLinkedNode head;
    DoubleLinkedNode end;
    int cap;
    int len;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer, DoubleLinkedNode>();
        cap = capacity;
        len = 0;
    }
    
    public void removeNode(DoubleLinkedNode node){
        if(node.pre != null)
            node.pre.next = node.next;
        else
            head = node.next;
            
        if(node.next != null)
            node.next.pre = node.pre;
        else
            end = node.pre;
    }
    
    public void setHead(DoubleLinkedNode node){
        node.pre = null;
        node.next = head;
        if(head != null)
            head.pre = node;
        
        head = node;
        
        if(end == null)
            end = node;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedNode tmp = map.get(key);
            removeNode(tmp);
            setHead(tmp);
            
            return tmp.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedNode tmp = map.get(key);
            tmp.val = value;
            removeNode(tmp);
            setHead(tmp);
            map.put(key, tmp);
        }
        else{
            DoubleLinkedNode tmp = new DoubleLinkedNode(key, value);
            if(len == cap){
                map.remove(end.key);
                end = end.pre;
                if(end != null)
                    end.next = null;
                len--;
            }
            setHead(tmp);
            map.put(key, tmp);
            len++;
        }
    }
}

/*
//TLE
public class LRUCache {
    Queue<Integer> keyQ;
    Map<Integer, Integer> map;
    int cap;
    
    public LRUCache(int capacity) {
        cap = capacity;
        keyQ = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            keyQ.remove(key);
            keyQ.add(key);
            int v = map.get(key);
            return v;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            keyQ.remove(key);
            keyQ.add(key);
        }
        else if(keyQ.size() == cap){
            int r = keyQ.poll();
            map.remove(r);
            keyQ.add(key);
            map.put(key, value);
        }
        else{
            keyQ.add(key);
            map.put(key, value);
        }
    }
}

*/
