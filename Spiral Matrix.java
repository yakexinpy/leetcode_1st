public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return ret;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int r = 0, c = 0;
        while(r < row / 2 && c < col / 2){
            int i = r, j = c;
            while(j < col - c - 1)
                ret.add(matrix[i][j++]);
            while(i < row - r - 1)
                ret.add(matrix[i++][j]);
            while(j > c)
                ret.add(matrix[i][j--]);
            while(i > r)
                ret.add(matrix[i--][j]);
            r++;
            c++;
        }
        
        if(r == row / 2 && row % 2 == 1 && c < col / 2){
            int j = c;
            while(j < col - c)
                ret.add(matrix[r][j++]);
        }
        else if(c == col / 2 && col % 2 == 1 && r < row / 2){
            int i = r;
            while(i < row - r)
                ret.add(matrix[i++][r]);
        }
        else if(col % 2 == 1 && row % 2 == 1)
            ret.add(matrix[r][c]);
        
        return ret;
    }
}
