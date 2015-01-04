public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length < 1 || target == 0) return ret;
        
        Arrays.sort(candidates);
            
        List<Integer> res = new ArrayList<Integer>();
        helper(candidates, 0, ret, res, target);
        return ret;
    }
    
    private void helper(int[] num, int start, List<List<Integer>> ret, List<Integer> res, int rest){
        if(rest < 0) return;
        if(rest == 0){
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        for(int i = start; i < num.length; i++){
            if(i > 0 && num[i] == num[i - 1]) continue;
            res.add(num[i]);
            helper(num, i, ret, res, rest - num[i]);
            res.remove(res.size() - 1);
        }
    }
}
