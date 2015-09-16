import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

	public class Solution {
	    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	        if(num.length < 3 || num == null)
	            return new ArrayList<ArrayList<Integer>>();
	        Arrays.sort(num);
	        
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        
	        for(int i = num.length - 1; i > 1; i--){
	            if(i < num.length -1 && num[i]==num[i+1])
	                continue;
	            ArrayList<ArrayList<Integer>> res = twoNum(num, i - 1, -num[i]);
	            result.addAll(res);
	        }    
	        return result;
	    }
	    
	    public static ArrayList<ArrayList<Integer>> twoNum(int[] num, int end, int tgt){
	        if(num.length < 2 || num == null)
	            return null;
	            
	        int l = 0;
	        int r = end;
	        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        while(l < r){
	            if(num[l] + num[r] == tgt){
	                ArrayList<Integer> item = new ArrayList<Integer>();
	                item.add(num[l]);
	                item.add(num[r]);
	                item.add(num[end + 1]);
	                result.add(item);
	                l++;
	                r--;
	                while(l < r && num[l] == num[l-1]  )
	                    l++;
	                while(r > l && num[r] == num[r+1])
	                    r--;
	            }
	            else if(num[l] + num[r] > tgt)
	                r--;
	            else
	                l++;
	        } 
	        return result;
	    }
	}
