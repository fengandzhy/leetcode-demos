package org.frank.leetcode.string.excel.sheet.column.title.demo01;

import java.util.ArrayList;
import java.util.List;

public class ExcelSheetColumnTitleSolution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        
        while(columnNumber > 0){            
            int remainder = columnNumber % 26;
            stringList.add(converToString(remainder));
            columnNumber = columnNumber / 26;
            if(remainder == 0){
                columnNumber = columnNumber - 1;
            }
        }
        int size = stringList.size();
        for(int i =size-1; i> -1; i--){
            sb.append(stringList.get(i));
        }
        return sb.toString();
    }
    
    public String converToString(int number){
       switch (number){
           case 1: 
               return "A";
           case 2:
               return "B";
           case 3:
               return "C";
           case 4:
               return "D";
           case 5:
               return "E";
           case 6:
               return "F";
           case 7:
               return "G";
           case 8:
               return "H";
           case 9:
               return "I";
           case 10:
               return "J";
           case 11:
               return "K";
           case 12:
               return "L";
           case 13:
               return "M";
           case 14:
               return "N";
           case 15:
               return "O";
           case 16:
               return "P";
           case 17:
               return "Q";
           case 18:
               return "R";
           case 19:
               return "S";
           case 20:
               return "T";
           case 21:
               return "U";
           case 22:
               return "V";
           case 23:
               return "W";
           case 24:
               return "X";
           case 25:
               return "Y";
           case 0:
               return "Z";
           default:
               return "";
       }
    }

    public static void main(String[] args) {
//        System.out.println(701 / 26);
//        System.out.println(701 % 26);
//        
//        System.out.println(25 / 26);  
        ExcelSheetColumnTitleSolution solution = new ExcelSheetColumnTitleSolution();
        solution.convertToTitle(701);
    }
}
