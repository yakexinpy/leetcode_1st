public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        if(num == null || num.length < 1)
            return ret;
        
        Arrays.sort(num);
        List<Integer> res = new ArrayList<Integer>();
        helper(num, 0, res, ret);
        return ret;
    }
    
    private void helper(int[] num, int start, List<Integer> res, List<List<Integer>> ret){
        for(int i = start; i < num.length; i++){
            if(i != start && (i > 0 && num[i] == num[i - 1])) continue;
            res.add(num[i]);
            ret.add(new ArrayList<Integer>(res));
            helper(num, i + 1, res, ret);
            res.remove(res.size() - 1);
        }
    }
}
