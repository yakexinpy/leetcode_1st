public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length < 1) return 0;
        
        int[] l2r = new int[ratings.length];
        int[] r2l = new int[ratings.length];
        
        l2r[0] = 1;
        for(int i = 1; i < l2r.length; i++){
            if(ratings[i] > ratings[i - 1])
                l2r[i] = l2r[i - 1] + 1;
            else
                l2r[i] = 1;
        }
        
        r2l[r2l.length - 1] = 1;
        for(int j = r2l.length - 2; j >= 0; j--){
            if(ratings[j] > ratings[j + 1])
                r2l[j] = r2l[j + 1] + 1;
            else
                r2l[j] = 1;
        }
        
        int candy = 0;
        for(int i = 0; i < ratings.length; i++)
            candy += Math.max(l2r[i], r2l[i]);
        
        return candy;
    }
}
