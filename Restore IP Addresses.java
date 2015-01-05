public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        if(s.length() > 12 || s.length() < 4) return ret;
        List<String> ip = new ArrayList<String>();
        helper(s, 0, ip, ret);
        return ret;
    }
    
    private void helper(String s, int index, List<String> ip, List<String> ret){
        if(ip.size() >= 4){
            if(index < s.length()) return;
            String str = "";
            str += ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3);
            ret.add(str);
            return;
        }
        
        if(index >= s.length()) return;
        
        ip.add(s.substring(index, index + 1));
        helper(s, index + 1, ip, ret);
        ip.remove(ip.size() - 1);
        
        if(s.charAt(index) == '0') return;
        
        if(index + 1 < s.length()){
            ip.add(s.substring(index, index + 2));
            helper(s, index + 2, ip, ret);
            ip.remove(ip.size() - 1);
        }
        
        if(index + 2 < s.length()){
            String str = s.substring(index, index + 3);
            if(Integer.parseInt(str) <= 255 && Integer.parseInt(str) >= 0){
                ip.add(str);
                helper(s, index + 3, ip, ret);
                ip.remove(ip.size() - 1);
            }
        }
    }
}
