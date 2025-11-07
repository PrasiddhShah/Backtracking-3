// Time Complexity :O(mn3^L)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes

/*
 * Approach
 * here are are using DFS and backtracking to solve the problem
 * 
 * we will first find the starting letter in of the word on the board
 * after the word is found we start the dfs
 * 
 * where will will use the dirs array to find the next char of the word
 * if not found then return false,come back one step and change the board to its previous state
 * if found, make that node visited and start the search for there again
 * 
 *  
 */

class Solution {
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int r, int c, int idx) {
        // base
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] == '#') {
            return false;
        }

        // logic
        if (board[r][c] == word.charAt(idx)) {
            // action
            board[r][c] = '#';

            // recurse
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (backtrack(board, word, nr, nc, idx + 1)) {
                    return true;
                }
            }
            // backtrack
            board[r][c] = word.charAt(idx);
        }
        return false;
    }
}