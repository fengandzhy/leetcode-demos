package org.frank.leetcode.array.sudoku.solver.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sudoku-solver/description/
 */
public class SudokuSolverSolution1 {
    public void solveSudoku(char[][] board) {
        boolean rows[][] = new boolean[9][9];
        boolean columns[][] = new boolean[9][9];
        boolean subBox[][][] = new boolean[3][3][9];
        boolean valid = false;
        List<int[]> space = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if(c == '.'){
                    space.add(new int[]{i,j});
                }else{
                    int digit = c - '0' - 1;
                    rows[i][digit] = false;
                    columns[j][digit] = false;
                    subBox[i/3][j/3][digit] = false;
                }
            }
        }
    }
    private void dfs(char[][] board, int pos) {
        
    }
}
