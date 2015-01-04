public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(num == null || num.length < 1 || target < 1) return ret;
        
        Arrays.sort(num);
        List<Integer> res = new ArrayList<Integer>();
        helper(num, 0, target, res, ret);
        return ret;
    }
    
    private void helper(int[] num, int start, int rest, List<Integer> res, List<List<Integer>> ret){
        if(rest == 0){
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        if(rest < 0 || start >= num.length) return;

        for(int i = start; i < num.length; i++){
            if(i > start && num[i] == num[i - 1]) continue;
            res.add(num[i]);
            helper(num, i + 1, rest - num[i], res, ret);
            res.remove(res.size() - 1);
        }
    }
}
