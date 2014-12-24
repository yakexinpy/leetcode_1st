public class Solution {
    public List<ArrayList<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(!dict.contains(end) || end == null || end.length() < 1) return ret;
        ArrayList<String> temp = new ArrayList<String>();
        if(start.equals(end)){
            temp.add(start);
            temp.add(end);
            ret.add(temp);
            return ret;
        }
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());
        for(String str : dict)
            map.put(str, new ArrayList<String>());
            
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        ArrayList<String> currLev = new ArrayList<String>();
        boolean isFin = false;
        
        while(!q.isEmpty() && !isFin){
            //int levelSize = q.size();
            currLev.clear();
            while(!q.isEmpty()){
                String str = q.poll();
                if(dict.contains(str))
                    dict.remove(str);
                currLev.add(str);
            }
            
            for(String str : currLev){
                for(int i = 0; i < str.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        char[] array = str.toCharArray();
                        array[i] = ch;
                        String nstr = new String(array);
                        
                        if(!nstr.equals(start) && nstr.equals(end)){
                            map.get(end).add(str);
                            //q.add(nstr);
                            isFin = true;
                        }
                        else if(!nstr.equals(str) && dict.contains(nstr)){
                            if(!q.contains(nstr)) q.add(nstr);
                            map.get(nstr).add(str);
                        }
                    }
                }
            }
        }
        temp.add(end);
        buildPath(start, end, map, temp, ret);
        return ret;
    }
    
    private void buildPath(String start, String end, 
                HashMap<String, ArrayList<String>> map,
                ArrayList<String> temp, ArrayList<ArrayList<String>> ret){
        ArrayList<String> pre = map.get(end);
        
        if(end.equals(start)){
            ArrayList<String> reverse = new ArrayList<String>(temp);
            Collections.reverse(reverse);
            ret.add(reverse);
            return;
        }
        
        for(String strp : pre){
            temp.add(strp);
            buildPath(start, strp, map, temp, ret);
            temp.remove(temp.size() - 1);
        }
    }
}
