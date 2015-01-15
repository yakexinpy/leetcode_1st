public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        if(L == null || L.length < 1) return ret;
        
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String s : L){
            if(dict.containsKey(s))
                dict.put(s, dict.get(s) + 1);
            else    
                dict.put(s, 1);
        }
        
        int len = L[0].length();
        for(int i = 0; i <= S.length() - len * L.length; i++){
            Map<String, Integer> cur = (HashMap<String, Integer>) dict.clone();
            String sub = S.substring(i, i + len * L.length);
            for(int j = 0; j < sub.length(); j += len){
                String str = sub.substring(j, j + len);
                if(cur.containsKey(str)){
                    cur.put(str, cur.get(str) - 1);
                    int num = cur.get(str);
                    if(num < 0) break;
                    if(num == 0 && j + len == sub.length()){
                        ret.add(i);
                        break;
                    }
                }
                else
                    break;
            }
        }
        return ret;
    }
}
