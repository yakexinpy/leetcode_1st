public class Solution {
    public List<Integer> grayCode(int n) {
        if(n < 0)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        int size = 1 << n;
        for(int i = 0; i < size; i++){
            result.add(getGrayCode(i));
        }
        return result;
    }
    
    public int getGrayCode(int n){
        return n^(n >> 1);
    }
}
