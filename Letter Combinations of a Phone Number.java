public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        result.add("");
        if(digits == null || digits.length() == 0)
            return result;
            
        for(int i = 0; i < digits.length(); i++){
            String comb = getLetters(digits.charAt(i));
            ArrayList<String> tmp = new ArrayList<String>();
            for(int k = 0; k < result.size(); k++){
                for(int j = 0; j < comb.length(); j++){
                    tmp.add(result.get(k) + comb.charAt(j));
                }
            }
            result = tmp;
        }
        return result;
    }
    
    
    
    private String getLetters(char ch){
        switch(ch){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
