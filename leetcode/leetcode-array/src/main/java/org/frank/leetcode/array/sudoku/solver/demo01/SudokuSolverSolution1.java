package org.frank.leetcode.array.sudoku.solver.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/sudoku-solver/description/
 * 一定要记住这里的 rows[i][digit] = true;  表示对于 第 i 列来说,  digit 这个数字已经有了
 * columns[j][digit] = true; 表示对于第 j 列来说, digit 这个数字已经有了
 * 一共9个 subBox, 这些subBox 组成一个二维数组, 那么 subBox[i / 3][j / 3][digit] = true; 表示对于其中某个subBox 来说 digit 数字已经有了
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
        dfs(board, 0);
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
            // 第 i 行中没有这个数字, 第 j 列中没有这个数字, 第 [i/3][j/3] 中没有这个数字
            if(!rows[i][digit] && !columns[j][digit] && !subBox[i/3][j/3][digit]){
                rows[i][digit] = true;
                columns[j][digit] = true;
                subBox[i/3][j/3][digit] = true;
                board[i][j] = (char)(digit + '0' +1); // 数字是从1到9不是从0到9所以这里必须加1
                dfs(board,pos+1);
                // 下面三个就是回溯, 就是说当从是上面的dfs(board,pos+1); 发现这个valid!=true, 那么重新设置成false
                rows[i][digit] = false; 
                columns[j][digit] = false;
                subBox[i/3][j/3][digit] = false;
            }
        }
    }    
}
