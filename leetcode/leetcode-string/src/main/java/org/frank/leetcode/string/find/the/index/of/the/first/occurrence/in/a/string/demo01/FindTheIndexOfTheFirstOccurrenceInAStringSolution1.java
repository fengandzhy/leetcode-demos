package org.frank.leetcode.string.find.the.index.of.the.first.occurrence.in.a.string.demo01;

public class FindTheIndexOfTheFirstOccurrenceInAStringSolution1 {

    public int strStr(String haystack, String needle) {
        return  haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAStringSolution1 solution1 = new FindTheIndexOfTheFirstOccurrenceInAStringSolution1();
        System.out.println(solution1.strStr("leetcode", "leeto"));
    }
}
