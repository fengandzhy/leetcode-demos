package org.frank.leetcode.array.count.items.matching.a.rule.demo01;

import java.util.List;

public class CountItemsMatchingARuleSolution1 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int itemCount = 0;
        if(ruleKey.equals("type")){
            for(List<String> prods:items){
                if(prods.get(0).equals(ruleValue)){
                    itemCount++;
                }
            }
        }
        if(ruleKey.equals("color")){
            for(List<String> prods:items){
                if(prods.get(1).equals(ruleValue)){
                    itemCount++;
                }
            }
        }
        if(ruleKey.equals("name")){
            for(List<String> prods:items){
                if(prods.get(2).equals(ruleValue)){
                    itemCount++;
                }
            }
        }
        return itemCount;
    }    
}
