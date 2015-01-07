public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] min = new int[triangle.get(size - 1).size()];
        
        for(int i = size - 1; i >= 0; i--){
            int line = triangle.get(i).size();
            for(int j = 0; j < line; j++){
                if(i == size - 1)
                    min[j] = triangle.get(i).get(j);
                else
                    min[j] = triangle.get(i).get(j) + Math.min(min[j], min[j + 1]);
            }
        }
        return min[0];
    }
}
