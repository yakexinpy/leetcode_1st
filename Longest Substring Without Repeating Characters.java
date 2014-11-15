public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        
        int len = 0;
        int max = 0;
        int last = 0;
        int cur = 0;
        while(cur < s.length()){     	
            if(hashmap.containsKey(s.charAt(cur))){
                int pos = hashmap.get(s.charAt(cur));
                if(pos >= last){
                	max = Math.max(len, max);
                	last = pos + 1;
                	len = cur - pos;
                	hashmap.put(s.charAt(cur), cur);
                	cur++;
                	continue;
                }
            }
            hashmap.put(s.charAt(cur), cur);
            cur++;
            len++;
        }
        
        return Math.max(len, max);
    }
}
