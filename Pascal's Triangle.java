public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return result;
        
        List<Integer> cur = new ArrayList<Integer>();
        List<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        for(int i = 2; i <= numRows; i++){
            int j = 1;
            cur.add(j);
            while(j < (i-1)/2 + 1){
                int val = last.get(j) + last.get(j - 1);
                cur.add(val);
                j ++;
            }
            while(j < i){
                cur.add(cur.get(i - j - 1));
                j++;
            }
            result.add(cur);
            last = new ArrayList<Integer>(cur);
            cur = new ArrayList<Integer>();
        }
        return result;
    }
}
