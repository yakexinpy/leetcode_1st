public class Solution {
    public List<ArrayList<Integer>> combine(int n, int k) {
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(n < 1 || k < 1 || k > n) return ret;

        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(n, k, 1, ret, res);
        return ret;
    }
    
    private void helper(int n, int k, int index, List<ArrayList<Integer>> ret, ArrayList<Integer> res){
        if(res.size() == k){
            ArrayList<Integer> temp = new ArrayList<Integer>(res);
            ret.add(temp);
            return;
        }
        
        for(int i = index; i <= n; i++){
            res.add(i);
            helper(n, k, i + 1, ret, res);
            res.remove(res.size() - 1);
        }
    }
}
