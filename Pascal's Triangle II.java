public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<Integer>();
        if(rowIndex < 0) return cur;
        
        cur.add(1);
        if(rowIndex == 0) return cur;
        
        for(int i = 1; i <= rowIndex; i++){
            int j = 1;
            int last = cur.get(j - 1);
            while(j < i/2 + 1){
                int val = cur.get(j) + last;
                last = cur.get(j);
                cur.set(j, val);
                j++;
            }
            while(j <= i){
                if(i >= cur.size() && j == cur.size())
                    cur.add(cur.get(i - j));
                else
                    cur.set(j, cur.get(i - j));
                j++;
            }
        }
        return cur;
    }
}
