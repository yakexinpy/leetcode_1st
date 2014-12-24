public class Solution {
    public int singleNumber(int[] A) {
        if(A == null || A.length < 1) return -1;
        if(A.length == 1) return A[0];
        
        int one = 0;
        int two = 0;
        int three = 0;
        for(int i = 0; i < A.length; i++){
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            two &= ~three;
            one &= ~three;
        }
        return one;
    }
    
    /*
    public int singleNumber(int[] A) {
        if(A == null || A.length < 1) return -1;
        if(A.length == 1) return A[0];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i]))
                map.put(A[i], 1);
            else
                map.put(A[i], map.get(A[i]) + 1);
        }
        
        for(Integer key : map.keySet())
            if(map.get(key) == 1)
                return key;
                
        return -1;
    }
    */
}
