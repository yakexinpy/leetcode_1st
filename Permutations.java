public class Solution {
    public List<ArrayList<Integer>> permute(int[] num) {
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 1) return ret;
        
        boolean[] visited = new boolean[num.length];
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(visited, num, ret, res);
        return ret;
    }
    
    private void helper(boolean[] visited, int[] num, List<ArrayList<Integer>> ret, List<Integer> res){
        if(res.size() == num.length){
            ret.add(new ArrayList<Integer>(res));
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            res.add(num[i]);
            helper(visited, num, ret, res);
            res.remove(res.size() - 1);
            visited[i] = false;
        }
    }
}
