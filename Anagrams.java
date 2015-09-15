public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> ret = new ArrayList<String>();
        if(strs == null || strs.length < 1) return ret;
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i = 0; i < strs.length; i++){
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String str = new String(chs);
            
            if(map.containsKey(str)){
                List<String> array = map.get(str);
                array.add(strs[i]);
                map.put(str, array);
            }
            else{
                List<String> array = new ArrayList<String>();
                array.add(strs[i]);
                map.put(str, array);
            }
        }
        
        Iterator iter = map.values().iterator();
        while(iter.hasNext()){
            List<String> array = (ArrayList<String>)iter.next();
            if(array.size() > 1)
                ret.addAll(array); 
        }
        return ret;
    }
}
