public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a == "") 
            return b;
        if(b == null || b == "")
            return a;
            
        String result = "";
        int alen = a.length();
        int blen = b.length();
        int index = 0;
        int count = 0;
        
        while(index < alen && index < blen){
            if(a.charAt(alen - index - 1) == '1' && a.charAt(alen - index - 1) == b.charAt(blen - index - 1)){
                if(count != 1){
                    count = 1;
                    result = "0" + result;
                }
                else
                    result = "1"+result;
            }
            else if(a.charAt(alen - index - 1) != b.charAt(blen - index - 1)){
                if(count != 1)
                    result = "1" + result;
                else
                    result = "0" + result;
            }
            else{
                if(count != 1)
                    result = "0" + result;
                else{
                    result = "1" + result;
                    count = 0;
                }
            }
            index++;
        }
        
        while(index < alen){
            if(count != 1){
                result = a.substring(0, alen - index) + result;
                break;
            }
            else{
                if(a.charAt(alen - index - 1) == '1')
                    result = "0" + result;
                else{
                    result = "1" + result;
                    count = 0;
                }
                index++;
            }
        }
        
        while(index < blen){
            if(count != 1){
                result = b.substring(0, blen - index) + result;
                break;
            }
            else{
                if(b.charAt(blen - index - 1) == '1')
                    result = "0" + result;
                else{
                    result = "1" + result;
                    count = 0;
                }
                index++;
            }
        }
        if(count == 1)
            result = "1" + result;
        return result;
    }
}
