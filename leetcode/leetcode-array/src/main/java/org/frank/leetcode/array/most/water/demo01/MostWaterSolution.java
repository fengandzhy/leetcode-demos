package org.frank.leetcode.array.most.water.demo01;

public class MostWaterSolution {
    /**
     * https://leetcode.cn/problems/container-with-most-water/description/
     * 
     * 
     * 
     * 
     * */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length -1;
        while(i < j){
            maxArea = Math.max(maxArea, calculateArea(i,height[i],j,height[j]));
            if(height[i] < height[j]){
                i++;
            }else{
                j --;
            }
        }
        return maxArea;
    }

    public int calculateArea(int i, int heightI, int j, int heightJ) {
        return (j-i) * Math.min(heightI,heightJ);
    }
}
