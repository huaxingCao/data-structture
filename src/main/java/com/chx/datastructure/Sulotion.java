package com.chx.pratice;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Sulotion {
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

    public static void main(String[] args) {
        Sulotion ss = new Sulotion();
        int[] array = {-1,-2,-3,-4,-5};

        int[] res  = ss.twoSum(array, -8);
        Arrays.stream(res).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

    }
}
