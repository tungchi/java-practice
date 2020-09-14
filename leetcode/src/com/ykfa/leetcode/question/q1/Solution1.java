package com.ykfa.leetcode.question.q1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingkefa
 * @date 2020年03月02日16:12:26
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int idx1 = 0; idx1 < nums.length; idx1++) {
            for (int idx2 = idx1 + 1; idx2 < nums.length; idx2++) {
                int rs = nums[idx1] + nums[idx2];
                if (rs == target) {
                    return new int[] {idx1, idx2};
                }
            }
        }
        return new int[] {0, 0};
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        long beginMills = System.nanoTime();
        int[] rs = solution1.twoSum1(new int[] {2, 7, 11, 15}, 22);
        System.out.println("耗时" + (System.nanoTime() - beginMills) / 1000 + "微秒");
        System.out.println("[" + rs[0] + "," + rs[1] + "]");
    }
}
