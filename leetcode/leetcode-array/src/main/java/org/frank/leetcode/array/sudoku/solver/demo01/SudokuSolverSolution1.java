package org.frank.leetcode.array.sudoku.solver.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sudoku-solver/description/
 */
public class SudokuSolverSolution1 {
    private boolean rows[][] = new boolean[9][9];
    private boolean columns[][] = new boolean[9][9];
    private boolean subBox[][][] = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> space = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == '.') {
                    space.add(new int[]{i, j});
                } else {
                    int digit = c - '0' - 1;
                    rows[i][digit] = true;
                    columns[j][digit] = true;
                    subBox[i / 3][j / 3][digit] = true;
                }
            }
        }
    }

    private void dfs(char[][] board, int pos) {
        if (pos == space.size()) {
            valid = true;
            return;
        }
        int[] temp = space.get(pos);
        int i = temp[0];
        int j = temp[1];
        for (int digit = 0; digit < 9 & !valid; digit++) {
            if(!rows[i][digit] && !columns[j][digit] && !subBox[i/3][j/3][digit]){
                rows[i][digit] = true;
                columns[j][digit] = true;
                subBox[i/3][j/3][digit] = true;
                board[i][j] = (char)(digit + '0' +1); // 数字是从1到9不是从0到9所以这里必须加1
                dfs(board,pos+1);
                // 下面三个就是回溯
                rows[i][digit] = false; 
                columns[j][digit] = false;
                subBox[i/3][j/3][digit] = false;
            }
        }
    }    
}
