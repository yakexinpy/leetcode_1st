public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        if(S.length < 1 || S == null) return ret;
        
        Arrays.sort(S);
        List<Integer> res = new ArrayList<Integer>();
        helper(0, S, ret, res);
        return ret;
    }
    
    private void helper(int start, int[] S, List<List<Integer>> ret, List<Integer> res){
        if(start > S.length - 1){
            return;
        }
        for(int i = start; i < S.length; i++){
            res.add(S[i]);
            ret.add(new ArrayList<Integer>(res));
            helper(i + 1, S, ret, res);
            res.remove(res.size() - 1);
        }
    }
}
