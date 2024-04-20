package org.frank.leetcode.array.find.the.duplicate.number.demo02;

/**
 * 方法的概念
 * 将数组视为一个链表。关键在于意识到：
 *
 * 数组中的每个元素可以被看作是一个“节点”。
 * 数组中每个索引处的值是指向下一个节点的“指针”（即下一个索引）。
 * 例如，如果数组是 [3, 1, 3, 4, 2]，可以将其视为一个链表：
 *
 * 索引0指向索引3（nums[0] = 3 表示下一个节点在索引3处）。
 * 索引1指向索引1（nums[1] = 1 表示下一个节点在索引1处），依此类推。
 * 由于数组中存在重复的数字，至少有两个索引必须指向同一个索引，从而形成一个循环。
 *
 * 应用乌龟和兔子算法
 * 该算法使用两个指针，通常称为“慢指针”（乌龟）和“快指针”（兔子）。具体操作如下：
 *
 * 从列表的开头开始两个指针（在数组的第一个元素处）。
 * 慢指针每次移动一步（乌龟移动到 nums[tortoise]）。
 * 快指针每次移动两步（兔子移动到 nums[nums[hare]]）。这意味着兔子的移动速度是乌龟的两倍。
 * 继续移动两个指针，直到它们相遇。由于兔子移动得更快，如果存在循环，兔子最终会在循环中追上乌龟。
 * 寻找循环的起点
 * 一旦检测到循环（即兔子和乌龟相遇）：
 *
 * 将其中一个指针重置到列表的开头。
 * 以相同的速度移动两个指针（每次一步）。
 * 它们再次相遇的点就是循环的起点，这对应于数组中的重复数字。
 * 这第二阶段有效的原因是，根据链表中循环的数学性质，从列表开始到循环开始的距离等于从循环中的相遇点回到循环开始的距离。
 *
 * 为什么这适用于找到重复的数字
 * 在问题背景下，给定一个数字范围为1到n的n+1个元素的数组，必定至少有一个重复的元素（根据抽屉原理）。重复创建了一个场景，即多个“节点”（数组元素）指向同一个“节点”（索引），形成一个环或循环。通过检测这个循环的起点，你实际上找到了重复的数字。
 *
 * 这种方法既节省空间又节省时间，只使用了两个指针（除此之外不使用额外空间），并且操作的时间复杂度为线性时间 O(n)，因为每个指针最多遍历列表两次。
 * 
 * */
public class FindTheDuplicateNumberSolution2 {
    public int findDuplicate(int[] nums) {
        // Phase 1: Finding the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            System.out.println(tortoise+","+hare);
        } while (tortoise != hare);
        System.out.println("==============================================");
        // Phase 2: Finding the entrance to the cycle (duplicate number).
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
            System.out.println(tortoise+","+hare);
        }

        return hare;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumberSolution2 solution2 = new FindTheDuplicateNumberSolution2();
        int[] nums = {2,5,7,6,9,3,8,9,4,1};        
        solution2.findDuplicate(nums);
        int a = nums[0];
        int index = 0;
        while(index < 100){
            index ++;
            System.out.print(a+",");
            a = nums[a];
        }
    }
}
