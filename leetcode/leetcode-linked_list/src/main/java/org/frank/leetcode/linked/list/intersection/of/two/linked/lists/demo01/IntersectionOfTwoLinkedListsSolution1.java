package org.frank.leetcode.linked.list.intersection.of.two.linked.lists.demo01;

import org.frank.leetcode.linked.list.intersection.of.two.linked.lists.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/?envType=study-plan-v2&envId=top-100-liked
 * 
 * */
public class IntersectionOfTwoLinkedListsSolution1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = null;
        List<ListNode> listA = new ArrayList<>();
        List<ListNode> listB = new ArrayList<>();
        if(headA == null || headB == null){
            return null;
        }
        while(true){
            if(headA != null && headB != null && headA.equals(headB)){ // 确保这两个刚好同步相等
                node = headA;
                break;
            }
            listA.add(headA);
            listB.add(headB);
            if(headA != null){
                headA = headA.next; 
            }
            if(headB !=null){
                headB = headB.next;
            }           
            if(listB.contains(headA)){
                node = headA;
                break;
            }
            if(listA.contains(headB)){
                node = headB;
                break;
            }            
        }
        return node;               
    }
}
