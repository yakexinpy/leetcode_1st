public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if(num == null || num.length < 4)
            return new ArrayList<ArrayList<Integer>>();
            
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i = num.length - 1; i > 2; i-- ){
            if(i != num.length - 1 && num[i] == num[i + 1])
        		continue;
            ArrayList<ArrayList<Integer>> sum3 = threeSum(num, i - 1, target - num[i]);
            result.addAll(sum3);
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for(int i = end; i > 1; i--){
            if(i != end && num[i] == num[i + 1])
        		continue;
            ArrayList<ArrayList<Integer>> sum2 = twoSum(num, i - 1, target - num[i]);
            for(int j = 0; j < sum2.size(); j++)
                sum2.get(j).add(num[end + 1]);
            result.addAll(sum2);
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        int l = 0;
        int r = end;
        while(l < r){
            if(num[l] + num[r] == target){
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[l]);
                item.add(num[r]);
                item.add(num[end + 1]);
                result.add(item);
                
                l++;
                r--;
                while(l < r && num[l] == num[l - 1])
                    l++;
                while(l < r && num[r] == num[r + 1])
                    r--;
            }
            else if(num[l] + num[r] > target)
                r--;
            else 
                l++;
        }
        return result;
    }
}
