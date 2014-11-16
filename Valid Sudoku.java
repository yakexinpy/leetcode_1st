public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        HashSet<Character> set = new HashSet<Character>();
        //each row
        for(int i = 0; i < row; i++){
            set.clear();
            for(int j = 0; j < col; j++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }
        
        //each column
        for(int j = 0; j < col; j++){
            set.clear();
            for(int i = 0; i < row; i++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }
        
        //each cell
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                set.clear();
                for(int r = i * 3; r < i * 3 + 3; r++ ){//row
                    for(int c = j * 3; c < j * 3 + 3; c++){
                        if(board[r][c] == '.')
                            continue;
                        if(set.contains(board[r][c]))
                            return false;
                        else
                            set.add(board[r][c]);
                    }
                    
                }
            }
        }
        return true;
    }
}
