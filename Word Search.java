public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() < 1) return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(0, i, j, board, word))
                    return true;
            }
        }
        return false;
    }
    
    private boolean helper(int index, int row, int col,  char[][] board, String word){
        if(index >= word.length())
            return true;
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(index))
            return false;
        
        board[row][col] = '*';
        boolean ret = helper(index + 1, row + 1, col, board, word);
        ret = ret || helper(index + 1, row - 1, col, board, word);
        ret = ret || helper(index + 1, row, col + 1, board, word);
        ret = ret || helper(index + 1, row, col - 1, board, word);
        
        board[row][col] = word.charAt(index);
        return ret;
    }
}
