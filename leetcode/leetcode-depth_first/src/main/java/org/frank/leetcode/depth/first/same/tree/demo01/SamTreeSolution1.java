package org.frank.leetcode.depth.first.same.tree.demo01;

public class SamTreeSolution1 {

    /**
     * https://leetcode.cn/problems/same-tree/ 
     * 
     * */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        return judgeTree(p,q);
    }
    
    /**
     * 保证传到这里的 p, q 都是非空的.
     * */
    public boolean judgeTree(TreeNode p, TreeNode q){
        boolean isLeftSame = true;
        boolean isRightSame = true;
        if(p == null && q != null){
            return false;
        }
        if(q == null && p != null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        if(p.left == null && q.left != null ){
            return false;
        }

        if(p.left != null && q.left == null ){
            return false;
        }
        
        if(p.left != null && q.left != null ){
            isLeftSame = judgeTree(p.left, q.left);
        }
        
        if(p.right == null && q.right != null ){
            return false;
        }

        if(p.right != null && q.right == null ){
            return false;
        }

        if(p.right != null && q.right != null ){
            isRightSame = judgeTree(p.right, q.right);
        }
        
        return isLeftSame && isRightSame;
    }
}
