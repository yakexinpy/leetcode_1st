public class Solution {
    public void solveSudoku(char[][] board) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    list.add(i * 9 + j);
            }
        }
        helper(board, list, 0);
    }
    
    private boolean helper(char[][] board, List<Integer> list, int cur){
        if(cur == list.size()) return true;
        int index = list.get(cur);
        int row = index / 9;
        int col = index % 9;
        
        for(int i = 1; i <= 9; i++){
            if(isValid(board, row, col, i)){
                board[row][col] = (char)(i + '0');
                if(helper(board, list, cur + 1)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, int v){
        for(int i = 0; i < 9; i++){
            if(board[row][i] - '0' == v) return false;
            if(board[i][col] - '0' == v) return false;
            int rs = 3 * (row / 3) + i / 3;
            int rc = 3 * (col / 3) + i % 3;
            if(board[rs][rc] - '0' == v) return false;
        }
        return true;
    }
}
