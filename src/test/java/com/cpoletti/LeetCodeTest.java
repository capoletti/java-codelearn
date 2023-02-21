package com.cpoletti;

import org.junit.Test;

import java.util.Arrays;

public class LeetCodeTest {


    @Test
    public void twoSum(){
        LeetCode lc = new LeetCode();
        System.out.println(Arrays.toString(lc.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(lc.twoSumV2(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void addTwoNumbers(){
        //l1 = [9,9,9,9,9,9,9]
        ListNode l1 = new ListNode(9);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);
        l1 = new ListNode(9, l1);

        //l2 = [9,9,9,9]
        ListNode l2 = new ListNode(9);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);
        l2 = new ListNode(9, l2);

        LeetCode lc = new LeetCode();
        ListNode r = lc.addTwoNumbers(l1, l2);

        while (r != null){
            System.out.print(r.val);
            r = r.next;
        }

        System.out.println("");

        l1 = new ListNode(2);
        l1 = new ListNode(4, l1);
        l1 = new ListNode(3, l1);

        l2 = new ListNode(5);
        l2 = new ListNode(6, l2);
        l2 = new ListNode(4, l2);

        r = lc.addTwoNumbers(l1, l2);

        while (r != null){
            System.out.print(r.val);
            r = r.next;
        }
    }

    @Test
    public void lengthOfLongestSubstring(){

        LeetCode lc = new LeetCode();
        int ret = lc.lengthOfLongestSubstring("dvdf"); //pwwkew //aabaab!bb //dvdf
        System.out.println(ret);
    }

    @Test
    public void findMedianSortedArrays() {
        LeetCode lc = new LeetCode();
        int[] nums1 ={1,2,3};
        int[] nums2 = {4,5,6};
        double ret = lc.findMedianSortedArraysV2(nums1,nums2);
        System.out.println(ret);
    }



}
