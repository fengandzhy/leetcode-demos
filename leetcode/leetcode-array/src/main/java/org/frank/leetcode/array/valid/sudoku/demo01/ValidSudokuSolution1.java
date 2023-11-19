package org.frank.leetcode.array.valid.sudoku.demo01;

import java.util.ArrayList;
import java.util.List;

public class ValidSudokuSolution1 {
    public boolean isValidSudoku(char[][] board) {
        List<Character> characters1 = new ArrayList<>();
        List<Character> characters2 = new ArrayList<>();
        List<Character> characters3 = new ArrayList<>();
        List<Character> characters4 = new ArrayList<>();
        List<Character> characters5 = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            characters1.removeAll(characters1);
            characters2.removeAll(characters2);
            if (i % 3 == 0) {
                characters3.removeAll(characters3);
                characters4.removeAll(characters4);
                characters5.removeAll(characters5);
            }
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && characters1.contains(board[i][j])) {
                    return false;
                } else {
                    characters1.add(board[i][j]);
                }

                if (board[j][i] != '.' && characters2.contains(board[j][i])) {
                    return false;
                } else {
                    characters2.add(board[j][i]);
                }
                if(j < 3){
                    if (board[i][j] != '.' && characters3.contains(board[i][j])) {
                        return false;
                    } else {
                        characters3.add(board[i][j]);
                    }
                }
                if(j >= 3 && j < 6){
                    if (board[i][j] != '.' && characters4.contains(board[i][j])) {
                        return false;
                    } else {
                        characters4.add(board[i][j]);
                    }
                }
                if(j >= 6){
                    if (board[i][j] != '.' && characters5.contains(board[i][j])) {
                        return false;
                    } else {
                        characters5.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
