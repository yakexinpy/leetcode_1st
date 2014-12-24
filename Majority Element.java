public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(map.containsKey(num[i]))
                map.put(num[i], map.get(num[i]) + 1);
            else
                map.put(num[i], 1);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i : map.keySet()){
            if(map.get(i) > max && map.get(i) > num.length / 2)
                max = i;
        }
        return max;
    }
}
