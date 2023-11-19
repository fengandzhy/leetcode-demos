package org.frank.leetcode.array.valid.sudoku.demo02;

public class ValidSudokuSolution2 {
    public boolean isValidSudoku(char[][] board) {
        int rows[][] = new int[9][9];
        int columns[][] = new int[9][9];
        int subBox[][][] = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    int index = c - '0' - 1; // 算出在数组中的位置, 例如3 在数组中的下标就是2;
                    rows[i][index]++;
                    columns[j][index]++; 
                    subBox[i/3][j/3][index]++;
                    if(rows[i][index] > 1 || columns[j][index] > 1 || subBox[i/3][j/3][index] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
