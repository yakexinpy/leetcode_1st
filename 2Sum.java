import java.util.Arrays;
import java.util.HashMap;


public class Solution {
	public static int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;
        
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++)
            hashmap.put(numbers[i], i + 1);
        
        int temp;
        for(int i = 0; i < numbers.length; i++){
            temp = target - numbers[i];
            if(hashmap.containsKey(temp) && hashmap.get(temp)!= i+1){
                index1 = i + 1;
                index2 = hashmap.get(temp);
                
                int[] result = new int[2]; 
                if(index1 > index2){
                	result[0] = index2;
                	result[1] = index1;
                }
                else{
                	result[0] = index1;
                	result[1] = index2;
                }
                return result;
            }
        }
        return new int[0];
    }
	
}
