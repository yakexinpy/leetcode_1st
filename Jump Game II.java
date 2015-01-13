public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length < 1) return 0;
        
        int steps = 0, index = 0, max = A[0];
        
        while(index < A.length - 1){
            steps++;
            if(max > A.length - 1) return steps;

            int newMax = max;
            for(int i = index + 1; i < max + 1; i++)
                newMax = Math.max(newMax, A[i] + i);
            index = max;
            max = newMax;
        }
        return steps;
    }
}
