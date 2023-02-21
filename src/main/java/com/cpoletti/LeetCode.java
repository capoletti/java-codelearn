package com.cpoletti;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeetCode {

    //Two Sum
    public int[] twoSum(int[] nums, int target) {

        int size = nums.length;

        for (int principalIndex = 0; principalIndex < size; principalIndex++) {
            int firstValue = nums[principalIndex];

            for (int secondaryIndex = principalIndex + 1; secondaryIndex < size; secondaryIndex++) {
                int secondValue = nums[secondaryIndex];

                if ((firstValue + secondValue) == target)
                    return new int[]{principalIndex, secondaryIndex};
            }
        }

        return new int[0];
    }

    //Two Sum
    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (map.containsKey(remain)) {
                int ri = map.get(remain);
                if (i != ri) {
                    result[0] = i;
                    result[1] = ri;
                    break;
                }
            }

        }
        return result;
    }

    //Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int sum = 0;
        ListNode result = new ListNode();
        ListNode current = result;

        while (l1 != null || l2 != null) {

            int v1 = 0;
            int v2 = 0;

            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            current.next = new ListNode(sum);
            current = current.next;
        }

        if (carry == 1) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {

        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
                //System.out.println("N:" + set);
            } else {
                set.remove(s.charAt(left++));
                //System.out.println("S:" + set);
            }
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] sortedList = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();

        int size = sortedList.length;
        int middle = size / 2;
        double med = 0;

        if (size % 2 == 0) {
            med = ((double) sortedList[middle] + (double) sortedList[middle - 1]) / 2;
        } else {
            med = (double) sortedList[middle];
        }

        return med;
    }


    public double findMedianSortedArraysV2(int[] nums1, int[] nums2) {

        int total = nums1.length + nums2.length;
        int half = total / 2;

        int[] minor = nums1;
        int[] major = nums2;

        if (nums1.length > nums2.length){
            minor = nums2;
            major = nums1;
        }

        int left = 0;
        int right = minor.length - 1;
        while (true){

            if ((right < 0) && ((left + right) % 2 != 0)) {
                right = right-1;
            }

            int indexMinor =  (left + right) / 2;
            int indexMajor = half - indexMinor  - 2;

            double minorLeft = Double.MAX_VALUE * -1;
            double minorRight  = Double.MAX_VALUE;
            double majorLeft = Double.MAX_VALUE * -1;
            double majorRight  = Double.MAX_VALUE;

            if (indexMinor >= 0) minorLeft = minor[indexMinor];
            if ((indexMinor + 1) < minor.length) minorRight = minor[indexMinor + 1];
            if (indexMajor >= 0) majorLeft = major[indexMajor];
            if ((indexMajor + 1) < major.length) majorRight = major[indexMajor + 1];

            if ((minorLeft <= majorRight) && (majorLeft <= minorRight)){
                if (total % 2 != 0){
                    return Math.min(minorRight, majorRight);
                }else{
                    return (Math.max(minorLeft, majorLeft) + Math.min(minorRight, majorRight))/2;
                }
            }

            if (minorLeft > majorRight){
                right = indexMinor - 1;
            }else{
                left = indexMinor + 1;
            }
        }
    }
}
