public class Solution {
    public String minWindow(String S, String T) {
        if(S.length() < T.length() || S.length() == 0)
            return "";
            
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        for(int i =0 ; i < T.length(); i++){
            if(hashmap.containsKey(T.charAt(i)))
                hashmap.put(T.charAt(i), hashmap.get(T.charAt(i)) + 1);
            else
                hashmap.put(T.charAt(i), 1);
        }
        
        int count = 0;
        int l = 0; 
        int r;
        int minLen = S.length() + 1;
        int minstart = 0;
        
        for(r = 0; r < S.length(); r++){
            if(hashmap.containsKey(S.charAt(r))){
                hashmap.put(S.charAt(r), hashmap.get(S.charAt(r)) - 1);
                
                if(hashmap.get(S.charAt(r)) >= 0)
                    count++;
                
            }
            
            while(count == T.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    minstart = l;
                }
                
                if(hashmap.containsKey(S.charAt(l))){
                    hashmap.put(S.charAt(l), hashmap.get(S.charAt(l)) + 1);
                    
                    if(hashmap.get(S.charAt(l)) > 0)
                        count--;
                    
                }
                    
                l++;
            }
        }
        
        if(minLen > S.length()){
            return "";
        }
        
        String result = S.substring(minstart, minstart + minLen );
        return result;
    }
}