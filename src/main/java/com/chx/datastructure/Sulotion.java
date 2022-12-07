package com.chx.pratice;

import java.util.Arrays;


public class Sulotion {

    /**
     * 二分法查找元素是否存在
     */
    public boolean binarySearch(int[] nums, int start, int end, int target) {
        boolean isExists = false;

        if (start >=0 && end < nums.length) {
            int index;
            while (end >= start) {
                index = (int) Math.floor((end + start) / 2);
                if (nums[index] == target) {
                    isExists = true;
                    break;
                } else if (nums[index] > target) {
                    end = index - 1;
                } else {
                    start = index + 1;
                }
            }
        }

        return isExists;
    }

    /**
     * leetcode 第1题
     */
    public int[] twoSum(int[] nums, int target) {
        int[] tmpNums = Arrays.copyOf(nums, nums.length);

        // 快排
        Arrays.sort(tmpNums);

        // 二分法查找
        boolean isExists = false;
        int num = 0;
        int anotherNum = 0;
        for (int i=0;i < tmpNums.length - 1;i++) {
            num = tmpNums[i];
            anotherNum = target - num;
            isExists = binarySearch(tmpNums, i+1,tmpNums.length - 1, anotherNum);
            System.out.println(isExists);
            if (isExists)
                break;
        }

        int[] indexArray = new int[2];
        if (isExists) {
            boolean first = false;
            boolean second = false;
            for (int i=0; i < nums.length; i++) {
                if (num == nums[i] && !first) {
                    indexArray[0] = i;
                    first = true;
                    continue;
                }
                if (anotherNum == nums[i] && !second) {
                    indexArray[1] = i;
                    second = true;
                }
            }
        }

        return indexArray;
    }


    /**
     * leetcode 第21题
     */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode last = head;
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        boolean flag = true;
        while (flag) {
            if (tmp1 == null) {
                last.next = tmp2;
                flag = false;
            } else if (tmp2 == null) {
                last.next = tmp1;
                flag = false;
            } else {
                if (tmp1.val <= tmp2.val) {
                    last.next = new ListNode(tmp1.val);
                    last = last.next;
                    tmp1 = tmp1.next;
                } else {
                    last.next = new ListNode(tmp2.val);
                    last = last.next;
                    tmp2 = tmp2.next;
                }
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(10);
        ListNode list2 = new ListNode(1);


        Sulotion ss = new Sulotion();
        ListNode res = ss.mergeTwoLists(list1, list2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

