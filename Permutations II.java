public class Solution {
    public List<ArrayList<Integer>> permuteUnique(int[] num) {
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length < 1) return ret;
        
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        List<Integer> temp = new ArrayList<Integer>();
        helper(ret, temp, num, visited);
        return ret;
    }
    
    private void helper(List<ArrayList<Integer>> ret, List<Integer> temp, int[] num, boolean[] visited){
        if(temp.size() == num.length){
            ArrayList<Integer> res = new ArrayList<Integer>(temp);
            ret.add(res);
            return;
        }
        
        for(int i = 0; i < num.length; i++){
            if(visited[i]) continue;
            if(i > 0 && num[i] == num[i - 1] && !visited[i - 1]){
                //visited[i] = true;
                continue;
            }
            visited[i] = true;
            temp.add(num[i]);
            helper(ret, temp, num, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
