package org.frank.leetcode.depth.first.minimum.depth.of.binary.tree.demo01;

public class MinimumDepthOfBinaryTreeSolution {

    public int minDepth(TreeNode root) {        
        if(root == null){
            return 0;
        }       
        return getDepth(root)+1;
    }

    public int getDepth(TreeNode node) {
        int leftDepth = 0; 
        int rightDepth = 0;
        if(node.left == null && node.right == null){
            return 0;
        }
        if(node.left!=null){
            leftDepth = getDepth(node.left) + 1;
        }
        if(node.right != null){
            rightDepth = getDepth(node.right) + 1;
        }
        if(node.left == null){
            return rightDepth;
        }
        if(node.right == null){
            return leftDepth;
        }        
        return Math.min(leftDepth, rightDepth);
    }
}
