package org.frank.leetcode.linked.list.merge.two.sorted.lists.demo01;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * */
public class MergeTwoSortedListsSolutions1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode heardNode = null;
//        ListNode currentNode = null;
//        ListNode previousNode = null;
        while(true){                        
            if(list1 == null && list2 == null){
                break;
            }
            if(list2 == null){
                heardNode = list1;
//                if(heardNode == null){
//                    heardNode = list1;
//                }
                break;
            }
            if(list1 == null){
                heardNode = list2;
//                if(heardNode == null){
//                   heardNode = list2; 
//                }
                break;
            }
            if(list1.val < list2.val){
                if(heardNode == null){
                    heardNode = list1;
                }
//                if(currentNode == null){
//                    currentNode = list1;
//                }
//                ListNode tempNode = currentNode;
//                currentNode = list1;
//                tempNode.next = currentNode;
                list1 = list1.next;
            }else {
                if(heardNode == null){
                    heardNode = list2;
                }
//                if(currentNode == null){
//                    currentNode = list2;
//                }
//                ListNode tempNode = currentNode;
//                currentNode = list2;
//                tempNode.next = currentNode;
                list2 = list2.next;
            }
        }
        return heardNode;
    }   
}
