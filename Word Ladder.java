public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(!dict.contains(end)) return 0;
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        int depth = 1;
        int currLev = 1;
        int nextLev = 0;
        HashSet<String> visited = new HashSet<String>();
        visited.add(start);
        
        while(!q.isEmpty()){
            String str = q.poll();
            currLev --;
            for(int i = 0; i < str.length(); i++){
                char[] array = str.toCharArray();
                for(char ch = 'a'; ch <= 'z'; ch++){
                    array[i] = ch;
                    String temp = new String(array);
                    if(temp.equals(end))
                        return depth + 1;
                    if(dict.contains(temp) && !visited.contains(temp)){
                        q.add(temp);
                        visited.add(temp);
                        nextLev ++;
                    }
                }
            }
            if(currLev == 0){
                currLev = nextLev;
                nextLev = 0;
                depth ++;
            }
        }
        return 0;
    }
    
}
