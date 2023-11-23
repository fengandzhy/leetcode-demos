package org.frank.leetcode.recursion.add.two.numbers.demo01;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 * */
public class AddTwoNumbersSolution1 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {        
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l2 == null && l1 != null){
            return l1;
        }
        if(l1 != null && l2 != null){
            ListNode node = new ListNode();
            int a1 = l1.val;
            int a2 = l2.val;
            int carry = 0;
            int a3 = a1 + a2;
            if(a3 > 9){
                carry = 1; // 进位计1的意思
                node.val = a3 % 10;
            }else{
                node.val = a3;
            }
            node.next = nextNode(l1.next, l2.next, carry);
            return node;
        }
        return null;
    }
    
    public ListNode nextNode(ListNode node1, ListNode node2, int carry){
        int a1 = 0;
        int a2 = 0;
        int carry1 = 0;
        if(node1 != null){
            a1 = node1.val;
        }
        if(node2 != null){
            a2 = node2.val;
        }
        int a3 = a1 + a2 + carry;
        
        if(node1 == null && node2 == null && carry == 0){
            return null;
        }
        
        ListNode node = new ListNode();
        if(a3 > 9){
            carry1 = a3 / 10;
            node.val = a3 % 10;
        } else {
            node.val = a3;
        }
        if(node1 == null && node2 !=null){
            node.next = nextNode(null, node2.next, carry1);
        }
        if(node2 == null && node1 !=null){
            node.next = nextNode(node1.next, null, carry1);
        }        
        if(node1 !=null && node2 !=null){
            node.next = nextNode(node1.next, node2.next, carry1);
        }        
        return node;
    }    
}
