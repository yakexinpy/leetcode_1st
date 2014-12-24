public class Solution {
    public static class Record{
        int index;
        String path;
        public Record(int i, String p){
            index = i;
            path = p;
        }
    }
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new ArrayList<String>();
        if(s == null || s.length() < 1) return ret;
        if(dict.size() < 1) return ret;
        boolean[] flag = new boolean[s.length() + 1];
        flag[0] = true;

        HashMap<Integer, ArrayList<Record>> map = new HashMap<Integer, ArrayList<Record>>();
        ArrayList<Record> value = new ArrayList<Record>();
        //value.add(new Record(0, ""));
        //map.put(0, value);
        
        //map.put(0, null);
        for(int i = 0; i < s.length(); i++){
            if(!flag[i]) continue;
            
            for(String str : dict){
                value = new ArrayList<Record>();
                int len = str.length();
                int end = i + len;
                if(end > s.length()) 
                	continue;
                if(str.equals(s.substring(i, end))){
                    flag[end] = true;
                    if(map.containsKey(end)){
                        value = map.get(end);
                        value.add(new Record(i, str));
                        map.put(end, value);
                    }
                    else{
                        value = new ArrayList<Record>();
                        value.add(new Record(i, str));
                        map.put(end, value);
                    }
                }
            }
        }
        if(flag[s.length()])
        	buildPath(map, ret, s.length(), "");
        return ret;
    }
    
    private void buildPath(HashMap<Integer, ArrayList<Record>> map, List<String> ret, int index, String str){
        if(index == 0) {
            ret.add(str.trim());
            return;
        }
        
        ArrayList<Record> array = map.get(index);
        for(int i = 0; i < array.size(); i++){
            int ind = array.get(i).index;
            buildPath(map, ret, ind, array.get(i).path + " " + str);
        }
    }
}
