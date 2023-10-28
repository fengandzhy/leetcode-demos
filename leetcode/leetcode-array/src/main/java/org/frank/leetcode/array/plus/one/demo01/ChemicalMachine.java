package org.frank.leetcode.array.plus.one.demo01;

import java.util.ArrayList;
import java.util.List;


public class ChemicalMachine {
    private List<String> container = new ArrayList<>();
    private ArrayList<String> colors = new ArrayList<>();   
    
    public void add(String chemical) {
        colors.clear();
        container.add(chemical);
    }

    public void applyHeat() {
        if(container.contains("GREEN") && container.contains("YELLOW") && container.size() ==2){
            colors.add("BROWN");
        }
        if(container.contains("GREEN") && container.contains("CYAN") && container.size() ==2){
            colors.add("ORANGE");
        }
        if(container.contains("ORANGE") && container.size() ==1) {
            colors.add("RED");
            colors.add("BLUE");
        }
        if(container.contains("BROWN") && container.size() == 1) {
            colors.add("MAGENTA");
        }
        if(container.size() > 0 && colors.size() == 0){
            colors.add("UNKNOWN");
        }
    }

    public ArrayList<String> emptyMachine() {           
        container.clear();        
        return colors;
    }

    public static void main(String[] args) {
        ChemicalMachine machine = new ChemicalMachine();

        machine.add("GREEN");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN

        machine.add("RED");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print UNKNOWN
    }
}
