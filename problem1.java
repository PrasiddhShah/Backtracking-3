// Time Complexity :O(n!)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes

/*
 * Approach
 * 
 * There are 3 main components to solve this problem
 * 
 * if is to check if the placed queen on each row is safe of not
 * we do that by check 3 component, left diagonal, right diagonal, and the straight column
 * 
 * if the check fails continue of the for loop else mark that portion in the board
 * increase the row+1 and do the recursive call on that row
 * 
 * when r == board.length
 * we create  new list and store the board value using a stringbuilder to make true as Q and false as .
 * 
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(boolean[][] board, int r, List<List<String>> result) {
        if (r == board.length) {
            List<String> li = new ArrayList<>();
            // convert the board into stirg
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == true) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            result.add(li);
        }
        //
        for (int c = 0; c < board.length; c++) {
            if (isSafe(board, r, c)) {
                board[r][c] = true;

                backtrack(board, r + 1, result);

                board[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int r, int c) {
        // same col check
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == true) {
                return false;
            }
        }
        // left diagolan
        int i = r;
        int j = c;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }
        // right diagolan
        i = r;
        j = c;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}