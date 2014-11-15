public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int columnLen = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[rowLen - 1][columnLen - 1])
            return false;
        
        int l = 0;
        int r = rowLen * columnLen - 1;
        int row, col;
        int mid = r / 2;
        while(l <= r){
            row = (mid/columnLen) % rowLen;
            col = mid % columnLen;
            if(matrix[row][col] == target)
                return true;
            if(matrix[row][col] < target)
                l = mid + 1;
            else
                r = mid - 1;
            mid = (l + r) / 2;
        }
        
        return false;
    }
}
