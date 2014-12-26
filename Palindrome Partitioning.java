public class Solution {
    public List<ArrayList<String>> partition(String s) {
        List<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(s == null || s.length() < 1) return ret;
        
        ArrayList<String> med = new ArrayList<String>();
        
        helper(ret, med, s);
        return ret;
    }
    
    private void helper(List<ArrayList<String>> ret, ArrayList<String> med, String s){
        if(s.length() == 0){
            ret.add(new ArrayList<String>(med));
            return;
        }
        
        int len = s.length();
        for(int i = 1; i <= len; i++){
            String str = s.substring(0, i);
            if(isPalindrome(str)){
                med.add(str);
                String rest = s.substring(i);
                helper(ret, med,rest);
                med.remove(med.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
