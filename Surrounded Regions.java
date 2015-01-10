public class Solution {
    public void solve(char[][] board) {
        if(board == null) return;
        int row = board.length;
        if(row < 3) return;
        int col = board[0].length;
        if(col < 3) return;
        
        for(int i = 0; i < row; i++){
            helper(i, 0, board);
            helper(i, col - 1, board);
        }
        
        for(int j = 0; j < col; j++){
            helper(0, j, board);
            helper(row - 1, j, board);
        }
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    
    private void helper(int i, int j, char[][] board){
        if(board[i][j] != 'O') return;
        int row = board.length;
        int col = board[0].length;
        board[i][j] ='*';
        int index = i * col + j;
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(index);
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            int r = tmp / col;
            int c = tmp % col;
            
            if(r > 0 && board[r - 1][c] == 'O'){
                q.add((r - 1) * col + c);
                board[r - 1][c] = '*';
            }
            if(r < row - 1 && board[r + 1][c] == 'O'){
                q.add((r + 1) * col + c);
                board[r + 1][c] = '*';
            }
            if(c > 0 && board[r][ c - 1] == 'O'){
                q.add(r * col + c - 1);
                board[r][c - 1] = '*';
            }
            if(c < col - 1 && board[r][c + 1] == 'O'){
                q.add(r * col + c + 1);
                board[r][c + 1] = '*';
            }
        }
        
    }
}
