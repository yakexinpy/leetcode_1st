public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < num.length; i++)
            set.add(num[i]);
            
        int max = 0;
        int len = 1;
        for(int i = 0; i < num.length; i++){
            if(set.contains(num[i])){
                set.remove(num[i]);
                int next = num[i] + 1;
                while(set.contains(next)){
                    set.remove(next);
                    next++;
                    len++;
                }
                next = num[i] - 1;
                while(set.contains(next)){
                    set.remove(next);
                    next--;
                    len++;
                }
                if(len > max)
                    max = len;
                len = 1;
            }
        }
        return max;
    }
}
