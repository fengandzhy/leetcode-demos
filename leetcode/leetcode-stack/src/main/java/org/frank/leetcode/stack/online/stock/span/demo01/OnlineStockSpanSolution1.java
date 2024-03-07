package org.frank.leetcode.stack.online.stock.span.demo01;

import java.util.Stack;

public class OnlineStockSpanSolution1 {
    private Stack<int[]> stack; // 使用栈存储价格和对应的跨度

    public OnlineStockSpanSolution1() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1; // 默认跨度为1
        // 当栈不为空，且当前价格大于等于栈顶元素的价格时，累加跨度并弹出栈顶元素
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        // 将当前价格和其跨度入栈
        stack.push(new int[]{price, span});
        return span; // 返回当前价格的跨度
    }
}
